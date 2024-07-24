package fr.pjapps.lydiatest.database.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import fr.pjapps.lydiatest.database.entity.ContactEntity
import kotlinx.coroutines.flow.Flow

/**
 * @author Loïc PAUL-JOSEPH.
 */
@Dao
interface ContactDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(contactEntity: ContactEntity): Long

    @Query("SELECT * FROM contacts")
    fun all(): PagingSource<Int, ContactEntity>

    @Query("SELECT * FROM contacts")
    fun allContact(): Flow<List<ContactEntity>>

    @Query("SELECT * FROM contacts WHERE uuid = :uuid")
    fun loadById(uuid: Long): Flow<ContactEntity>

    @Query("DELETE FROM contacts")
    fun deleteAll()
}
