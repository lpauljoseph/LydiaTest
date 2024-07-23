package fr.pjapps.lydiatest.model

data class Contact(
    val id: Long,
    val gender: String,
    val title: String,
    val first: String,
    val last: String,
    val phone: String,
    val cell: String,
    val email: String,
)
