package zafar.abdulloev.aliftest.domain.model

import androidx.room.Entity
import zafar.abdulloev.aliftest.IMAGE_TABLE

@Entity(tableName = IMAGE_TABLE)
class ImageEntity(
    val endDate: String,
    val icon: String,
    val name: String,
    val startDate: String,
    val url: String
)