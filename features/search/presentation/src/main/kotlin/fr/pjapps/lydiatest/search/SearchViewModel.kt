package fr.pjapps.lydiatest.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.pjapps.lydiatest.repository.ContactRepository
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val contactRepository: ContactRepository
) : ViewModel() {

    var contactsStateFlow = MutableStateFlow(SearchResultUiState())
        private set

    init {
        viewModelScope.launch {
            contactRepository.fetchContacts(1)
            contactRepository.getAllContacts().collect { contacts ->
                contactsStateFlow.value = SearchResultUiState(contacts.map { SearchContactUiState(it) }.toImmutableList())
            }
        }
    }
}
