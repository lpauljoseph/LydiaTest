package fr.pjapps.lydiatest.repository

import fr.pjapps.lydiatest.datasource.ContactLocalDataSource
import fr.pjapps.lydiatest.datasource.ContactRemoteDataSource
import fr.pjapps.lydiatest.datasource.model.ContactDb
import fr.pjapps.lydiatest.model.Contact
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

open class ContactRepositoryImpl @Inject constructor(
    private val contactRemoteDataSource: ContactRemoteDataSource,
    private val contactLocalDataSource: ContactLocalDataSource
) : ContactRepository {

    override suspend fun fetchContacts(page: Int): Unit = withContext(Dispatchers.IO) {
        // fetch data
        val data = contactRemoteDataSource.fetch(page)
        // insert in database
        contactLocalDataSource.insert(data.results)
    }

    override fun getAllContacts(): Flow<List<Contact>> =
        contactLocalDataSource.all().map { list -> list.map { it.toDomain() } }

}

internal fun ContactDb.toDomain() = Contact(
    id = id,
    gender = gender,
    title = title,
    first = firstName,
    last = lastName,
    phone = phone,
    cell = cell,
    email = email,
)
