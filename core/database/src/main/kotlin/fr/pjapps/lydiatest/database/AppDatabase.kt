package fr.pjapps.lydiatest.database

import androidx.room.Database
import androidx.room.RoomDatabase
import fr.pjapps.lydiatest.database.dao.ContactDao
import fr.pjapps.lydiatest.database.dao.PageDao
import fr.pjapps.lydiatest.database.entity.ContactEntity
import fr.pjapps.lydiatest.database.entity.PageEntity

/**
 * @author Loïc PAUL-JOSEPH.
 */
@Database(
    entities = [ContactEntity::class, PageEntity::class],
    version = 1,
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun contactDao(): ContactDao
    abstract fun pageDao(): PageDao
}
