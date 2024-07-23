package fr.pjapps.lydiatest.datasource.remote

import fr.pjapps.lydiatest.datasource.model.ResultModelApi
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Service to retrieve all contacts
 */
interface ApiService {
    @GET("?seed=lydia&results=20")
    suspend fun getContacts(
        @Query("page") page: Int
    ): ResultModelApi
}
