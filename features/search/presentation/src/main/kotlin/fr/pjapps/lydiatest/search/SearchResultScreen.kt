package fr.pjapps.lydiatest.search

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.LazyPagingItems

/**
 * @author Loïc PAUL-JOSEPH
 */

@Composable
fun SearchResultScreen(
    searchPagedData: LazyPagingItems<SearchContactUiState>,
    navigateToDetail: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    val listState = rememberLazyListState()

    LazyColumn(
        state = listState,
        modifier = modifier
    ) {
        items(count = searchPagedData.itemCount) { index ->
            val contact = searchPagedData[index]
            contact?.let {
                ContactItemView(contact = contact) { navigateToDetail(it) }
            }
        }
    }

//    LazyColumn(
//        state = listState,
//        modifier = modifier
//    ) {
//        items(
//            items = searchResultUiState.contacts,
//            key = { contact -> contact.uuid }
//        ) { contact ->
//            ContactItemView(contact = contact) { navigateToDetail(it) }
//        }
//    }
}
