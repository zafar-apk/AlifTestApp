package zafar.abdulloev.aliftest.domain

import androidx.paging.PagingSource
import androidx.paging.PagingState
import retrofit2.Response
import zafar.abdulloev.aliftest.data.model.Guide
import zafar.abdulloev.aliftest.data.model.GuidesResponse
import zafar.abdulloev.aliftest.data.repo.interfaces.GuidesRepo
import zafar.abdulloev.aliftest.domain.model.FullGuideEntity
import zafar.abdulloev.aliftest.domain.model.FullGuideWithVenue
import zafar.abdulloev.aliftest.domain.model.GuideEntity

class FakeGuidesRepo : GuidesRepo {

    var isFullGuideInserted = false
    var isGuidesInserted = false
    var isGetGuidesFromNetworkCalled = false
    var isGetSingleGuideFromNetworkCalled = false

    var count = 0

    val pagingSource by lazy {
        object : PagingSource<Int, GuideEntity>() {
            override fun getRefreshKey(state: PagingState<Int, GuideEntity>) = 0
            override suspend fun load(params: LoadParams<Int>) =
                LoadResult.Error<Int, GuideEntity>(RuntimeException())
        }
    }

    var guidesFromNetworkResponse = Response.success(GuidesResponse())

    var singleGuideFromNetworkResponse = Response.success(Guide(icon = "", name = ""))

    var singleGuideFromDB: FullGuideWithVenue? =
        FullGuideWithVenue(FullGuideEntity(icon = "", name = ""), null)

    override suspend fun getGuidesFromNetwork(): Response<GuidesResponse> {
        isGetGuidesFromNetworkCalled = true
        return guidesFromNetworkResponse
    }

    override suspend fun getSingleGuideFromNetwork(id: String): Response<Guide> {
        isGetSingleGuideFromNetworkCalled = true
        return singleGuideFromNetworkResponse
    }

    override suspend fun getSingleGuideFromDB(id: String): FullGuideWithVenue? {
        return singleGuideFromDB
    }

    override fun getGuidesFromDB(): PagingSource<Int, GuideEntity> {
        return pagingSource
    }

    override suspend fun insertToDB(vararg entity: GuideEntity) {
        isGuidesInserted = true

    }

    override suspend fun getCountInDB(): Int {
        return count
    }

    override suspend fun insertFullGuideToDB(entity: FullGuideWithVenue) {
        isFullGuideInserted = true
    }
}