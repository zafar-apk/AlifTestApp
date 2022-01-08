package zafar.abdulloev.aliftest.data.model


import com.google.gson.annotations.SerializedName

class Guide(
    @SerializedName("bundleVersion")
    val bundleVersion: Int? = null,
    @SerializedName("endDate")
    val endDate: String? = null,
    @SerializedName("gb_url")
    val gbUrl: String? = null,
    @SerializedName("guideVersion")
    val guideVersion: Int? = null,
    @SerializedName("icon")
    val icon: String,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("inviteOnly")
    val inviteOnly: Boolean? = null,
    @SerializedName("loginRequired")
    val loginRequired: Boolean? = null,
    @SerializedName("minAppVersion-Android")
    val minAppVersionAndroid: Int? = null,
    @SerializedName("minAppVersion-iOS")
    val minAppVersionIOS: Int? = null,
    @SerializedName("name")
    val name: String,
    @SerializedName("ownerId")
    val ownerId: Int? = null,
    @SerializedName("productIdentifier")
    val productIdentifier: String? = null,
    @SerializedName("startDate")
    val startDate: String? = null,
    @SerializedName("type")
    val type: String? = null,
    @SerializedName("venue")
    val venue: Venue? = null
)