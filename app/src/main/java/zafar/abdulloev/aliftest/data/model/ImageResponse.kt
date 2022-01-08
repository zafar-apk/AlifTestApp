package zafar.abdulloev.aliftest.data.model

import com.google.gson.annotations.SerializedName

class ImageResponse(
    @SerializedName("data")
    val data: List<Image> = emptyList(),
    @SerializedName("total")
    val total: Int = 0
)
