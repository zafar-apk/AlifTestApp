package zafar.abdulloev.aliftest.presenter.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import zafar.abdulloev.aliftest.R

@Composable
fun GuideIcon(
    modifier: Modifier = Modifier.size(80.dp),
    url: String
) {

    Image(
        modifier = modifier,
        painter = rememberImagePainter(data = url) {
            placeholder(R.drawable.placeholder)
        },
        contentDescription = "Guide icon"
    )

}