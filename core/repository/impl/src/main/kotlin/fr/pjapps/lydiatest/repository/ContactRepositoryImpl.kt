package fr.pjapps.lydiatest.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import fr.pjapps.lydiatest.database.entity.ContactEntity
import fr.pjapps.lydiatest.datasource.local.LocalDataSource
import fr.pjapps.lydiatest.datasource.remote.ContactRemoteMediator
import fr.pjapps.lydiatest.model.Contact
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

open class ContactRepositoryImpl @Inject constructor(
    private val contactRemoteMediator: ContactRemoteMediator,
    private val contactLocalDataSource: LocalDataSource,
) : ContactRepository {

    @OptIn(ExperimentalPagingApi::class)
    override fun fetchContacts(): Flow<PagingData<Contact>> =
        // fetch data
        Pager(
            config = PagingConfig(pageSize = 20),
            remoteMediator = contactRemoteMediator,
            pagingSourceFactory = { contactLocalDataSource.pagedContacts() }
        ).flow.map {
            it.map { contact -> contact.toDomain() }
        }

    override fun getAllContacts(): Flow<List<Contact>> =
        contactLocalDataSource.all().map { list -> list.map { it.toDomain() } }

    override fun getContact(uuid: String): Flow<Contact> =
        contactLocalDataSource.getContact(uuid).map { it.toDomain() }

}

internal fun ContactEntity.toDomain() = Contact(
    uuid = uuid, gender, title, firstName, lastName, phone, cell, email
)
