package zafar.abdulloev.aliftest.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class GuideRemoteKey(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val prev: Int?,
    val next: Int?
)