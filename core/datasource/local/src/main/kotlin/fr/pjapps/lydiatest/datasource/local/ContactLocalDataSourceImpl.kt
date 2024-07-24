package fr.pjapps.lydiatest.datasource.local

import androidx.paging.PagingSource
import fr.pjapps.lydiatest.database.dao.ContactDao
import fr.pjapps.lydiatest.database.dao.PageDao
import fr.pjapps.lydiatest.database.entity.ContactEntity
import fr.pjapps.lydiatest.database.entity.PageEntity
import fr.pjapps.lydiatest.model.Contact
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val contactDao: ContactDao,
    private val pageDao: PageDao
) {

    fun pagedContacts(): PagingSource<Int, ContactEntity> =
        contactDao.all()

    suspend fun insert(results: List<Contact>) = withContext(Dispatchers.IO) {
        results.map { contactDao.insert(it.toEntity()) }
    }

    fun all(): Flow<List<ContactEntity>> = contactDao.allContact()

    fun getContact(contactUUID: String) = contactDao.loadById(contactUUID)

    suspend fun getPageNumber(): PageEntity = withContext(Dispatchers.IO) {
        pageDao.getPage()
    }

    suspend fun upsertPageNumber(pageEntity: PageEntity) = withContext(Dispatchers.IO) {
        pageDao.insert(pageEntity)
    }
}

internal fun Contact.toEntity() = ContactEntity(
    uuid, title, first, last, phone, cell, email, gender
)
