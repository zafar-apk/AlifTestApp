package zafar.abdulloev.aliftest.data.repo

import retrofit2.Response
import retrofit2.http.GET
import zafar.abdulloev.aliftest.data.model.GuidesResponse

interface Api {

    @GET("upcomingGuides")
    suspend fun fetchData(): Response<GuidesResponse>

}