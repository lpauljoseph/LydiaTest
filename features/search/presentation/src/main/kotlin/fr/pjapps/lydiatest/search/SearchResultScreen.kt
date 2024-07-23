package fr.pjapps.lydiatest.search

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * @author Loïc PAUL-JOSEPH
 */

@Composable
fun SearchResultScreen(
    searchResultUiState: SearchResultUiState,
    navigateToDetail: (Long) -> Unit,
    modifier: Modifier = Modifier,
) {
    val listState = rememberLazyListState()
    LazyColumn(
        state = listState,
        modifier = modifier
    ) {
        items(
            items = searchResultUiState.contacts,
            key = { contact -> contact.id }
        ) { contact ->
            ContactItemView(contact = contact) { navigateToDetail(it) }
        }
    }
}
