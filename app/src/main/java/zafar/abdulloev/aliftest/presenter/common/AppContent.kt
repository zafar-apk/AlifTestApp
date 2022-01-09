package zafar.abdulloev.aliftest.presenter.common

import android.widget.Toast
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
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

    val currentEntry by navHostController.currentBackStackEntryAsState()
    val hasBackButton =
        currentEntry?.destination?.route?.contains(Screen.DetailsScreen.route) ?: false

    val appName = stringResource(id = R.string.app_name)
    val appTitle = remember { mutableStateOf(appName) }
    val scaffoldState = rememberScaffoldState()

    val errorState = remember {
        mutableStateOf(ErrorModel())
    }

    SnackBar(errorState, scaffoldState)

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopBar(
                navController = navHostController,
                hasBackButton = hasBackButton,
                title = appTitle.value
            )
        }
    ) { paddings ->

        NavHost(
            modifier = Modifier.padding(paddings),
            navController = navHostController,
            startDestination = Screen.MasterScreen.route
        ) {

            composable(Screen.MasterScreen.route) {
                MasterScreen(navHostController, errorState)
            }

            composable(Screen.DetailsScreen.route + "/{$GUIDE_URL}") { entry ->
                val url = entry.arguments?.get(GUIDE_URL)?.toString()
                DetailsScreen(navHostController, appTitle, errorState, url)
            }
        }
    }
}

@Composable
private fun SnackBar(
    errorState: MutableState<ErrorModel>,
    scaffoldState: ScaffoldState,
) {
    val errorText = stringResource(id = R.string.error_text)
    val retryAgain = stringResource(id = R.string.retry)

    LaunchedEffect(key1 = errorState.value.isError) {
        if (errorState.value.isError) {
            val result = scaffoldState.snackbarHostState.showSnackbar(
                message = errorText,
                actionLabel = retryAgain,
                duration = SnackbarDuration.Indefinite
            )

            if (result == SnackbarResult.ActionPerformed) {
                errorState.value.action()
            }
        }
    }
}