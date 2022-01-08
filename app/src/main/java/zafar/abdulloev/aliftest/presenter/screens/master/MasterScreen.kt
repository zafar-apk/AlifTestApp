package zafar.abdulloev.aliftest.presenter.screens.master

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import zafar.abdulloev.aliftest.domain.model.ErrorModel
import zafar.abdulloev.aliftest.domain.model.GuideEntity
import zafar.abdulloev.aliftest.domain.screen_state.MainScreenState
import zafar.abdulloev.aliftest.presenter.components.GuideItem
import zafar.abdulloev.aliftest.presenter.components.Loading

@Composable
fun MasterScreen(
    navController: NavController,
    errorState: MutableState<ErrorModel>,
    viewModel: MasterViewModel = hiltViewModel()
) {

    val screenState by viewModel.screenState
    val guides = (screenState as? MainScreenState.Success)?.data?.collectAsLazyPagingItems()

    Error(screenState, errorState, viewModel)

    Guides(guides)

    Loading(
        isLoading = screenState is MainScreenState.Loading
                && errorState.value.isError.not()
    )

}

@Composable
private fun Guides(guides: LazyPagingItems<GuideEntity>?) {
    guides?.let {
        LazyColumn {
            item {
                Spacer(modifier = Modifier.size(16.dp))
            }

            items(guides) { guide ->
                if (guide != null) {
                    GuideItem(guide)
                }
            }
        }
    }
}

@Composable
private fun Error(
    screenState: MainScreenState,
    errorState: MutableState<ErrorModel>,
    viewModel: MasterViewModel
) {
    LaunchedEffect(key1 = screenState) {
        if (screenState is MainScreenState.Error) {
            errorState.value = ErrorModel(
                isError = true,
                action = viewModel::loadGuides
            )
        }
    }
}