package zafar.abdulloev.aliftest.domain.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import zafar.abdulloev.aliftest.FULL_GUIDE_TABLE

@Entity(tableName = FULL_GUIDE_TABLE)
class FullGuideEntity(
    @PrimaryKey
    val id: Int? = null,
    val bundleVersion: Int? = null,
    val endDate: String? = null,
    val gbUrl: String? = null,
    val guideVersion: Int? = null,
    val icon: String,
    val inviteOnly: Boolean? = null,
    val loginRequired: Boolean? = null,
    val minAppVersionAndroid: Int? = null,
    val minAppVersionIOS: Int? = null,
    val name: String,
    val ownerId: Int? = null,
    val productIdentifier: String? = null,
    val startDate: String? = null,
    val type: String? = null
)