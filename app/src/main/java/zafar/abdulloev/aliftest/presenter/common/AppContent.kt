package zafar.abdulloev.aliftest.presenter.common

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import zafar.abdulloev.aliftest.GUIDE_URL
import zafar.abdulloev.aliftest.R
import zafar.abdulloev.aliftest.domain.model.ErrorModel
import zafar.abdulloev.aliftest.domain.model.Screen
import zafar.abdulloev.aliftest.presenter.components.TopBar
import zafar.abdulloev.aliftest.presenter.screens.details.DetailsScreen
import zafar.abdulloev.aliftest.presenter.screens.master.MasterScreen

@Composable
fun AppContent() {

    val navHostController = rememberNavController()

    val errorState = remember {
        mutableStateOf(ErrorModel())
    }

    val currentEntry by navHostController.currentBackStackEntryAsState()
    val hasBackButton = currentEntry?.destination?.route?.contains(Screen.DetailsScreen.route) ?: false
    val appName = stringResource(id = R.string.app_name)
    val appTitle = remember { mutableStateOf(appName) }

    Scaffold(topBar = {
        TopBar(
            navController = navHostController,
            hasBackButton = hasBackButton,
            title = appTitle.value
        )
    }) { paddings ->

        NavHost(
            modifier = Modifier.padding(paddings),
            navController = navHostController,
            startDestination = Screen.MasterScreen.route
        ) {

            composable(Screen.MasterScreen.route) {
                MasterScreen(navHostController, errorState)
            }

            composable(Screen.DetailsScreen.route + "/{$GUIDE_URL}") {
                val url = it.arguments?.get(GUIDE_URL)?.toString()
                DetailsScreen(navHostController, appTitle, url)
            }

        }

    }

}