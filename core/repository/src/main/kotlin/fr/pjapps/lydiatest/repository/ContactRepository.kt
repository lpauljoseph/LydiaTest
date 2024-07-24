package fr.pjapps.lydiatest.repository

import androidx.paging.PagingData
import fr.pjapps.lydiatest.model.Contact
import kotlinx.coroutines.flow.Flow

interface ContactRepository {

    fun fetchContacts() : Flow<PagingData<Contact>>

    fun getAllContacts(): Flow<List<Contact>>
}
