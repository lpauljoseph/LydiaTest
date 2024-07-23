package fr.pjapps.lydiatest.datasource

import fr.pjapps.lydiatest.datasource.model.ContactDb
import fr.pjapps.lydiatest.datasource.model.ContactModelApi
import kotlinx.coroutines.flow.Flow

interface ContactLocalDataSource {
    fun all(): Flow<List<ContactDb>>
    fun insert(contacts: List<ContactModelApi>)
}
