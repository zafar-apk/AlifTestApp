package zafar.abdulloev.aliftest.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import zafar.abdulloev.aliftest.GUIDE_TABLE

@Entity(tableName = GUIDE_TABLE)
class GuideEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val endDate: String,
    val icon: String,
    val name: String,
    val startDate: String,
    val url: String
)