package fr.pjapps.lydiatest.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author Loïc PAUL-JOSEPH.
 */
@Entity(
    tableName = "contacts",
)
data class ContactEntity(
    @PrimaryKey val uuid: String,
    val title: String,
    @ColumnInfo(name = "first_name") val firstName: String,
    @ColumnInfo(name = "last_name") val lastName: String,
    val phone: String,
    val cell: String,
    val email: String,
    val gender: String,
    val thumbnail: String,
    val image: String,
    val bigPicture: String,
)
