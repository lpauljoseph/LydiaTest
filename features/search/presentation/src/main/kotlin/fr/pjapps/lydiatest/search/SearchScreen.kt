package fr.pjapps.lydiatest.search

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.flow.StateFlow

@Composable
fun SearchScreenNavigation(
    navigateToDetail: (Long) -> Unit,
    viewModel: SearchViewModel = hiltViewModel(),
) {
    SearchScreen(
        navigateToDetail = navigateToDetail,
        searchResultFlow = viewModel.contactsStateFlow
    )
}

@Composable
internal fun SearchScreen(
    navigateToDetail: (Long) -> Unit,
    searchResultFlow: StateFlow<SearchResultUiState>
) {

    Scaffold { innerPaddings ->

        SearchResultScreen(
            modifier = Modifier.padding(innerPaddings),
            searchResultUiState = searchResultFlow.collectAsStateWithLifecycle(
                SearchResultUiState()
            ).value,
            navigateToDetail = navigateToDetail
        )
    }
}
