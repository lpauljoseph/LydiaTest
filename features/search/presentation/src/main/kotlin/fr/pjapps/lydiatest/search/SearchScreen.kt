package fr.pjapps.lydiatest.search

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import kotlinx.coroutines.flow.Flow

@Composable
fun SearchScreenNavigation(
    navigateToDetail: (String) -> Unit,
    viewModel: SearchViewModel = hiltViewModel(),
) {
    viewModel.contactsPaged.collectAsLazyPagingItems()
    SearchScreen(
        navigateToDetail = navigateToDetail,
        searchResultPagedFlow = viewModel.contactsPaged
    )
}

@Composable
internal fun SearchScreen(
    navigateToDetail: (String) -> Unit,
    searchResultPagedFlow: Flow<PagingData<SearchContactUiState>>
) {

    Scaffold { innerPaddings ->

        SearchResultScreen(
            modifier = Modifier.padding(innerPaddings),
            searchPagedData = searchResultPagedFlow.collectAsLazyPagingItems(),
            navigateToDetail = navigateToDetail
        )
    }
}
