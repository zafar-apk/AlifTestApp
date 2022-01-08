package zafar.abdulloev.aliftest.data.repo

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import zafar.abdulloev.aliftest.data.model.Guide
import zafar.abdulloev.aliftest.data.model.GuidesResponse

interface Api {

    @GET("upcomingGuides")
    suspend fun fetchData(): Response<GuidesResponse>

    @GET("guides/{id}")
    suspend fun getSingleGuide(@Path("id") id: String): Response<Guide>

}