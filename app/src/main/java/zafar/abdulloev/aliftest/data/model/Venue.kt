package zafar.abdulloev.aliftest.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Venue(
    val guideId: Int = 0,
    @SerializedName("address")
    val address: String? = null,
    @SerializedName("city")
    val city: String? = null,
    @SerializedName("country")
    val country: String? = null,
    @SerializedName("state")
    val state: String? = null,
    @SerializedName("street")
    val street: String? = null,
    @SerializedName("zipcode")
    val zipcode: String? = null,
    @SerializedName("zoom")
    val zoom: String? = null,
    @PrimaryKey(autoGenerate = true)
    val id: Int
)