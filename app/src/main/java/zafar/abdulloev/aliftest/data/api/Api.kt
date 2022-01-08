package zafar.abdulloev.aliftest.data.api

import retrofit2.Response
import retrofit2.http.GET
import zafar.abdulloev.aliftest.data.model.ImageResponse

interface Api {

    @GET("upcomingGuides")
    suspend fun fetchData(): Response<ImageResponse>

}