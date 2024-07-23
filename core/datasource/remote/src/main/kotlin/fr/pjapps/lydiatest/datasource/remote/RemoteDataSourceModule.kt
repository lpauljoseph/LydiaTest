package fr.pjapps.lydiatest.datasource.remote

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import fr.pjapps.lydiatest.datasource.ContactRemoteDataSource
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataSourceModule {

    @Provides
    @Singleton
    fun provideApiService(): ApiService {
        return RetrofitInstance.retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideContactRemoteDataSource(apiService: ApiService): ContactRemoteDataSource {
        return ContactRemoteDataSourceImpl(apiService)
    }
}
