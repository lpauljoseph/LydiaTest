package fr.pjapps.lydiatest.datasource.model

data class ContactDb(
    val id: Long,
    val title: String,
    val firstName: String,
    val lastName: String,
    val phone: String,
    val cell: String,
    val email: String,
    val gender: String,
)
