package fr.pjapps.lydiatest.datasource.local

import fr.pjapps.lydiatest.database.dao.ContactDao
import fr.pjapps.lydiatest.database.entity.ContactEntity
import fr.pjapps.lydiatest.datasource.ContactLocalDataSource
import fr.pjapps.lydiatest.datasource.model.ContactDb
import fr.pjapps.lydiatest.datasource.model.ContactModelApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ContactLocalDataSourceImpl @Inject constructor(
    private val dao: ContactDao
) : ContactLocalDataSource {

    override fun all(): Flow<List<ContactDb>> =
        dao.all().map { list -> list.map { it.toDTO() } }

    override fun insert(contacts: List<ContactModelApi>) {
        contacts.map { dao.insert(it.toEntity()) }
    }
}

internal fun ContactEntity.toDTO() = ContactDb(
    id, title, firstName, lastName, phone, cell, email, gender,
)

internal fun ContactModelApi.toEntity() = ContactEntity(
    id = 0L,
    title = name.title,
    firstName = name.first,
    lastName = name.last,
    phone = phone,
    cell = cell,
    email = email,
    gender = gender,
)
