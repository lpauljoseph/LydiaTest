package fr.pjapps.lydiatest.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author Loïc PAUL-JOSEPH.
 */
@Entity(
    tableName = "page",
)
data class PageEntity(
    @PrimaryKey val id: Int,
    val number: Int,
)
