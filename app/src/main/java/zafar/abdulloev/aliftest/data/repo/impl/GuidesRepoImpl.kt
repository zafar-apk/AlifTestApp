package zafar.abdulloev.aliftest.data.repo.impl

import zafar.abdulloev.aliftest.data.db.GuideDao
import zafar.abdulloev.aliftest.data.repo.Api
import zafar.abdulloev.aliftest.data.repo.interfaces.GuidesRepo
import zafar.abdulloev.aliftest.domain.model.GuideEntity
import javax.inject.Inject

class GuidesRepoImpl @Inject constructor(
    private val api: Api,
    private val dao: GuideDao
) : GuidesRepo {

    override suspend fun getGuidesFromNetwork() = api.fetchData()

    override fun getGuidesFromDB() = dao.getGuides()

    override suspend fun insert(vararg entity: GuideEntity) = dao.insertGuides(*entity)

    override suspend fun getCount() = dao.getCount()
}