package fr.pjapps.lydiatest.repository

import fr.pjapps.lydiatest.model.Contact
import kotlinx.coroutines.flow.Flow

interface ContactRepository {

    suspend fun fetchContacts(page: Int)

    fun getAllContacts(): Flow<List<Contact>>
}
