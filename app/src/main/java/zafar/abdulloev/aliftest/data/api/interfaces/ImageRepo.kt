package zafar.abdulloev.aliftest.data.api.interfaces

import retrofit2.Response
import zafar.abdulloev.aliftest.data.model.ImageResponse

interface ImageRepo {
    suspend fun fetchData(): Response<ImageResponse>
}