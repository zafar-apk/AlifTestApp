package zafar.abdulloev.aliftest.presenter.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import zafar.abdulloev.aliftest.presenter.common.theme.Typography

@Composable
fun TopBar(
    navController: NavController,
    hasBackButton: Boolean = false,
    title: String = ""
) {

    TopAppBar(modifier = Modifier.fillMaxWidth()) {
        AnimatedVisibility(visible = hasBackButton) {
            IconButton(onClick = navController::navigateUp) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back button"
                )
            }
        }

        Text(
            modifier = Modifier.padding(horizontal = 8.dp),
            text = title,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = Typography.subtitle1
        )
    }

}