package fr.pjapps.lydiatest.search

import androidx.compose.runtime.Stable
import fr.pjapps.lydiatest.model.Contact
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Stable
data class SearchResultUiState(
    val contacts: ImmutableList<SearchContactUiState> = persistentListOf()
)

@Stable
data class SearchContactUiState(
    val id: Long,
    val title: String,
    val firstName: String,
    val lastName: String,
    val gender: String,
    val phone: String,
    val cell: String,
) {
    constructor(contact: Contact) : this(
        id = contact.id,
        title = contact.title,
        firstName = contact.first,
        lastName = contact.last,
        gender = contact.gender,
        cell = contact.cell,
        phone = contact.phone,
    )
}

