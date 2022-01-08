package zafar.abdulloev.aliftest.presenter.common

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import zafar.abdulloev.aliftest.GUIDE_URL
import zafar.abdulloev.aliftest.domain.model.ErrorModel
import zafar.abdulloev.aliftest.domain.model.Screen
import zafar.abdulloev.aliftest.presenter.screens.details.DetailsScreen
import zafar.abdulloev.aliftest.presenter.screens.master.MasterScreen

@Composable
fun AppContent() {

    val navHostController = rememberNavController()
    val errorState = remember {
        mutableStateOf(ErrorModel())
    }

    Scaffold(topBar = {}) { paddings ->

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
                DetailsScreen(navHostController, url)
            }

        }

    }

}