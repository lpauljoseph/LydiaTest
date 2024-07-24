package fr.pjapps.lydiatest.datasource.remote

import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Service to retrieve all contacts
 */
interface ApiService {
    @GET("?seed=lydia")
    suspend fun getContacts(
        @Query("page") page: Int,
        @Query("results") pageSize: Int = 20,
    ): ResultModelApi
}
