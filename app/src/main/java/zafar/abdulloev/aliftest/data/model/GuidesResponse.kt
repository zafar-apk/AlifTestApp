package zafar.abdulloev.aliftest.data.model

import com.google.gson.annotations.SerializedName

class GuidesResponse(
    @SerializedName("data")
    val data: List<BaseGuide> = emptyList(),
    @SerializedName("total")
    val total: Int = 0
)
