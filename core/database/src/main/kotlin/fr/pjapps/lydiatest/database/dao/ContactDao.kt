package fr.pjapps.lydiatest.database.dao

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

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(plantEntity: ContactEntity): Long

    @Query("SELECT * FROM contacts")
    fun all(): Flow<List<ContactEntity>>

    @Query("SELECT * FROM contacts WHERE id = :id")
    fun loadById(id: Long): Flow<ContactEntity>

    @Query("DELETE FROM contacts")
    fun deleteAll()
}
