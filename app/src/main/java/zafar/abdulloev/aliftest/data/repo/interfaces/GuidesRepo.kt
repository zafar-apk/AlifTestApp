package zafar.abdulloev.aliftest.data.repo.interfaces

import androidx.paging.PagingSource
import retrofit2.Response
import zafar.abdulloev.aliftest.data.model.Guide
import zafar.abdulloev.aliftest.data.model.GuidesResponse
import zafar.abdulloev.aliftest.domain.model.FullGuideEntity
import zafar.abdulloev.aliftest.domain.model.FullGuideWithVenue
import zafar.abdulloev.aliftest.domain.model.GuideEntity

interface GuidesRepo {

    suspend fun getGuidesFromNetwork(): Response<GuidesResponse>

    suspend fun getSingleGuideFromNetwork(id: String): Response<Guide>

    suspend fun getSingleGuideFromDB(id: String): FullGuideWithVenue?

    fun getGuidesFromDB(): PagingSource<Int, GuideEntity>

    suspend fun insertToDB(vararg entity: GuideEntity)

    suspend fun getCountInDB(): Int

    suspend fun insertFullGuideToDB(entity: FullGuideWithVenue)

}