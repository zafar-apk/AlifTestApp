package zafar.abdulloev.aliftest.data.repo.impl

import zafar.abdulloev.aliftest.data.db.GuideDao
import zafar.abdulloev.aliftest.data.repo.Api
import zafar.abdulloev.aliftest.data.repo.interfaces.GuidesRepo
import zafar.abdulloev.aliftest.domain.model.FullGuideWithVenue
import zafar.abdulloev.aliftest.domain.model.GuideEntity
import javax.inject.Inject

class GuidesRepoImpl @Inject constructor(
    private val api: Api,
    private val dao: GuideDao
) : GuidesRepo {

    override suspend fun getGuidesFromNetwork() = api.fetchData()

    override suspend fun getSingleGuideFromNetwork(id: String) = api.getSingleGuide(id)

    override suspend fun getSingleGuideFromDB(id: String): FullGuideWithVenue? =
        dao.getSingleGuide(id)

    override fun getGuidesFromDB() = dao.getGuides()

    override suspend fun insertToDB(vararg entity: GuideEntity) = dao.insertGuides(*entity)

    override suspend fun getCountInDB() = dao.getCount()

    override suspend fun insertFullGuideToDB(entity: FullGuideWithVenue) =
        dao.insertFullGuide(entity)
}