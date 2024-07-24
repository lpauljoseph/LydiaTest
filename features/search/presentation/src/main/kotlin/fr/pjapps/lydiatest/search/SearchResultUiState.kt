package fr.pjapps.lydiatest.search

import androidx.compose.runtime.Stable
import fr.pjapps.lydiatest.model.Contact

@Stable
data class SearchContactUiState(
    val uuid: String,
    val title: String,
    val firstName: String,
    val lastName: String,
    val gender: String,
    val phone: String,
    val cell: String,
) {
    constructor(contact: Contact) : this(
        uuid = contact.uuid,
        title = contact.title,
        firstName = contact.first,
        lastName = contact.last,
        gender = contact.gender,
        cell = contact.cell,
        phone = contact.phone,
    )
}
