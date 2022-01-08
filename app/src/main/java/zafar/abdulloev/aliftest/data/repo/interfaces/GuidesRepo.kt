package zafar.abdulloev.aliftest.data.repo.interfaces

import androidx.paging.PagingSource
import retrofit2.Response
import zafar.abdulloev.aliftest.data.model.GuidesResponse
import zafar.abdulloev.aliftest.domain.model.GuideEntity

interface GuidesRepo {

    suspend fun getGuidesFromNetwork(): Response<GuidesResponse>

    fun getGuidesFromDB(): PagingSource<Int, GuideEntity>

    suspend fun insert(vararg entity: GuideEntity)

    suspend fun getCount(): Int

}