package zafar.abdulloev.aliftest.data.model


import com.google.gson.annotations.SerializedName

class BaseGuide(
    @SerializedName("endDate")
    val endDate: String? = null,
    @SerializedName("icon")
    val icon: String? = null,
    @SerializedName("loginRequired")
    val loginRequired: Boolean? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("objType")
    val objType: String? = null,
    @SerializedName("startDate")
    val startDate: String? = null,
    @SerializedName("url")
    val url: String? = null,
)