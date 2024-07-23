package fr.pjapps.lydiatest.datasource.remote

import fr.pjapps.lydiatest.datasource.ContactRemoteDataSource
import fr.pjapps.lydiatest.datasource.model.ResultModelApi
import javax.inject.Inject

class ContactRemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService
) : ContactRemoteDataSource {

    override suspend fun fetch(page: Int): ResultModelApi =
        apiService.getContacts(page)

}
