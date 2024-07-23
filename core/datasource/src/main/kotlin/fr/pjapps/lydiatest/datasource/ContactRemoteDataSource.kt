package fr.pjapps.lydiatest.datasource

import fr.pjapps.lydiatest.datasource.model.ContactModelApi
import fr.pjapps.lydiatest.datasource.model.ResultModelApi

interface ContactRemoteDataSource {

    suspend fun fetch(page:Int) : ResultModelApi
}
