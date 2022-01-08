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
import zafar.abdulloev.aliftest.domain.model.Screen
import zafar.abdulloev.aliftest.domain.screen_state.ScreenState
import zafar.abdulloev.aliftest.presenter.components.GuideItem
import zafar.abdulloev.aliftest.presenter.components.Loading

@Composable
fun MasterScreen(
    navController: NavController,
    errorState: MutableState<ErrorModel>,
    viewModel: MasterViewModel = hiltViewModel()
) {

    val screenState by viewModel.screenState
    val guides = (screenState as? ScreenState.Success)?.data?.collectAsLazyPagingItems()

    Error(screenState, errorState, viewModel)

    Guides(
        guides,
        onClick = { url ->
            navController.navigate(
                Screen.DetailsScreen.passId(url.substringAfterLast('/'))
            )
        }
    )

    Loading(
        isLoading = screenState is ScreenState.Loading
                && errorState.value.isError.not()
    )

}

@Composable
private fun Guides(guides: LazyPagingItems<GuideEntity>?, onClick: (String) -> Unit) {
    guides?.let {
        LazyColumn {
            item {
                Spacer(modifier = Modifier.size(16.dp))
            }

            items(guides) { guide ->
                if (guide != null) {
                    GuideItem(guide, onClick = onClick)
                }
            }
        }
    }
}

@Composable
private fun Error(
    screenState: ScreenState<*>,
    errorState: MutableState<ErrorModel>,
    viewModel: MasterViewModel
) {
    LaunchedEffect(key1 = screenState) {
        if (screenState is ScreenState.Error) {
            errorState.value = ErrorModel(
                isError = true,
                action = viewModel::loadGuides
            )
        }
    }
}