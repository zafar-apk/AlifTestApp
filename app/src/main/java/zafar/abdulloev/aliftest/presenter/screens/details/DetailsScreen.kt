package zafar.abdulloev.aliftest.presenter.screens.details

import android.content.res.Configuration
import android.content.res.Configuration.ORIENTATION_LANDSCAPE
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import zafar.abdulloev.aliftest.R
import zafar.abdulloev.aliftest.domain.model.FullGuideEntity
import zafar.abdulloev.aliftest.domain.model.FullGuideWithVenue
import zafar.abdulloev.aliftest.domain.screen_state.ScreenState
import zafar.abdulloev.aliftest.presenter.common.theme.Typography
import zafar.abdulloev.aliftest.presenter.components.GuideIcon
import zafar.abdulloev.aliftest.presenter.components.Loading

/**
 * Api doesn't open web site for the given [url],
 * but i found a route that returns [FullGuideEntity] by id.
 *
 * Now i will display the name, city, state, and end date
 * */

@Composable
fun DetailsScreen(
    navController: NavController,
    appTitle: MutableState<String>,
    url: String?,
    viewModel: DetailsViewModel = hiltViewModel()
) {

    val screenState by viewModel.screenState
    val appName = stringResource(id = R.string.app_name)
    val guide = screenState as? ScreenState.Success

    val currentConfiguration = LocalConfiguration.current
    val isLandScape = currentConfiguration.orientation == ORIENTATION_LANDSCAPE

    SetTitle(screenState, guide, appTitle)

    guide?.data?.let { fullGuide ->

        if (isLandScape) {
            Row(
                Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                GuideIconInternal(fullGuide, isLandScape)

                Spacer(modifier = Modifier.size(16.dp))

                Body(currentConfiguration, fullGuide, isLandScape)
            }
        } else {
            Body(currentConfiguration, fullGuide, isLandScape)
        }
    }

    Loading(isLoading = screenState is ScreenState.Loading)

    DisposableEffect(key1 = Unit) {
        onDispose { appTitle.value = appName }
    }
}

@Composable
private fun Body(
    currentConfiguration: Configuration,
    fullGuide: FullGuideWithVenue,
    isLandScape: Boolean
) {
    Column(
        modifier = if (isLandScape) {
            Modifier
                .fillMaxSize()
                .padding(16.dp)
        } else Modifier.padding(16.dp)
    ) {

        if (!isLandScape) {
            GuideIconInternal(fullGuide, false)
        }

        Spacer(modifier = Modifier.size(16.dp))

        Text(text = fullGuide.fullGuideEntity.name, style = Typography.subtitle1)

        Spacer(modifier = Modifier.size(16.dp))

        fullGuide.venue?.city?.let { city ->
            Text(
                text = buildString {
                    append(stringResource(id = R.string.city_label))
                    append(city)
                },
                style = Typography.subtitle2
            )
        }

        fullGuide.venue?.state?.let { state ->
            Text(
                text = buildString {
                    append(stringResource(id = R.string.state_label))
                    append(state)
                },
                style = Typography.subtitle2
            )
        }

        fullGuide.fullGuideEntity.endDate?.let { endDate ->
            Text(
                modifier = Modifier.align(End),
                text = buildString {
                    append(stringResource(id = R.string.end_date_label))
                    append(endDate)
                },
                style = Typography.subtitle2
            )
        }
    }
}

@Composable
private fun GuideIconInternal(
    fullGuide: FullGuideWithVenue,
    isLandScape: Boolean
) {
    GuideIcon(
        url = fullGuide.fullGuideEntity.icon,
        modifier = if (isLandScape) Modifier
            .size(200.dp)
        else Modifier
            .fillMaxWidth()
            .height(200.dp)
    )
}

@Composable
private fun SetTitle(
    screenState: ScreenState<FullGuideWithVenue>,
    guide: ScreenState.Success<FullGuideWithVenue>?,
    appTitle: MutableState<String>
) {
    LaunchedEffect(key1 = screenState) {
        guide?.data?.fullGuideEntity?.name?.let {
            appTitle.value = it
        }
    }
}