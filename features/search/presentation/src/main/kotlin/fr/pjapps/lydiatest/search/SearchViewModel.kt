package fr.pjapps.lydiatest.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.pjapps.lydiatest.repository.ContactRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    contactRepository: ContactRepository
) : ViewModel() {

    val contactsPaged: Flow<PagingData<SearchContactUiState>> =
        contactRepository.fetchContacts()
            .map { page -> page.map { SearchContactUiState(it) } }
            .cachedIn(viewModelScope)

}
