package zafar.abdulloev.aliftest.presenter.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import zafar.abdulloev.aliftest.R
import zafar.abdulloev.aliftest.domain.model.GuideEntity
import zafar.abdulloev.aliftest.presenter.common.theme.Typography

@Composable
fun GuideItem(guide: GuideEntity) {

    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .padding(bottom = 16.dp)
    ) {
        Column(Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                modifier = Modifier.size(80.dp),
                painter = rememberImagePainter(data = guide.icon),
                contentDescription = "Guide icon"
            )

            Text(text = guide.name, style = Typography.subtitle1)

            Spacer(modifier = Modifier.size(8.dp))

            Text(
                text = buildString {
                    append(stringResource(id = R.string.start_date_label))
                    append(guide.startDate)

                    append(stringResource(id = R.string.end_date_label))
                    append(guide.endDate)
                },
                style = Typography.body1
            )
        }
    }

}