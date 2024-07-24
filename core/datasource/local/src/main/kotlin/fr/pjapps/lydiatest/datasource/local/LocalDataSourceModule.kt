package fr.pjapps.lydiatest.datasource.local

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import fr.pjapps.lydiatest.database.dao.ContactDao
import fr.pjapps.lydiatest.database.dao.PageDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalDataSourceModule {

    @Provides
    @Singleton
    fun provideContactLocalDataSource(contactDao: ContactDao, pageDao: PageDao): LocalDataSource {
        return LocalDataSource(contactDao, pageDao)
    }
}
