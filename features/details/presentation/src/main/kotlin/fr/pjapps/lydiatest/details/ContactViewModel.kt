package fr.pjapps.lydiatest.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.pjapps.lydiatest.model.Contact
import fr.pjapps.lydiatest.repository.ContactRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContactViewModel @Inject constructor(
    private val repository: ContactRepository,
) : ViewModel() {

    private val _contactDetails = MutableStateFlow(Contact())
    val contactDetails: StateFlow<Contact> = _contactDetails

    fun fetch(uuid: String?) {
        viewModelScope.launch {
            uuid?.let {
                repository.getContact(uuid).collectLatest {
                    _contactDetails.value = it
                }
            }
        }
    }
}
