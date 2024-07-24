package fr.pjapps.lydiatest.datasource.remote

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import fr.pjapps.lydiatest.database.entity.ContactEntity
import fr.pjapps.lydiatest.database.entity.PageEntity
import fr.pjapps.lydiatest.datasource.local.LocalDataSource
import fr.pjapps.lydiatest.model.Contact
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class ContactRemoteMediator @Inject constructor(
    private val contactRemoteDataSource: ContactRemoteDataSource,
    private val localDataSource: LocalDataSource,
) : RemoteMediator<Int, ContactEntity>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, ContactEntity>
    ): MediatorResult {
        val page = when (loadType) {
            LoadType.REFRESH -> {
                localDataSource.upsertPageNumber(PageEntity(1, 1))
                1
            }

            LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)
            LoadType.APPEND -> {
                val pageEntity = localDataSource.getPageNumber()
                pageEntity.number + 1
            }
        }

        localDataSource.upsertPageNumber(PageEntity(1, page))
        return try {
            val pageSize = state.config.pageSize
            val response = contactRemoteDataSource.fetchContacts(page, pageSize = pageSize)

            localDataSource.insert(response.results.map { it.toDomain() })

            MediatorResult.Success(endOfPaginationReached = response.results.isEmpty())
        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        }
    }
}

internal fun ContactModelApi.toDomain() = Contact(
    uuid = login.uuid,
    gender = gender,
    title = name.title,
    first = name.first,
    last = name.last,
    phone = phone,
    cell = cell,
    email = email,
    thumbnail = picture.thumbnail,
    image = picture.medium,
    bigPicture = picture.large,
)
