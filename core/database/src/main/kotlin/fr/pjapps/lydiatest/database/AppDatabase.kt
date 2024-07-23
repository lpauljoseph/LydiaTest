package fr.pjapps.lydiatest.database

import androidx.room.Database
import androidx.room.RoomDatabase
import fr.pjapps.lydiatest.database.dao.ContactDao
import fr.pjapps.lydiatest.database.entity.ContactEntity

/**
 * @author Loïc PAUL-JOSEPH.
 */
@Database(
	entities = [ContactEntity::class, ],
	version = 1,
	exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {
	abstract fun contactDao(): ContactDao
}