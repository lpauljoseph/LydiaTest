package fr.pjapps.lydiatest.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import fr.pjapps.lydiatest.database.entity.PageEntity

@Dao
interface PageDao {

    @Query("SELECT * FROM page")
    fun getPage(): PageEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(page: PageEntity)
}
