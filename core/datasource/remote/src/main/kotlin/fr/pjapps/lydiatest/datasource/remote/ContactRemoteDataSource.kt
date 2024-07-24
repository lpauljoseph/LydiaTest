package fr.pjapps.lydiatest.datasource.remote

import javax.inject.Inject

class ContactRemoteDataSource @Inject constructor(
    private val apiService: ApiService,
) {

    suspend fun fetchContacts(page: Int, pageSize: Int): ResultModelApi =
        apiService.getContacts(page, pageSize)
}
