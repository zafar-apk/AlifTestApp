package zafar.abdulloev.aliftest.data.repo.impl

import zafar.abdulloev.aliftest.data.repo.Api
import zafar.abdulloev.aliftest.data.repo.interfaces.ImageRepo
import zafar.abdulloev.aliftest.data.db.ImagesDao
import zafar.abdulloev.aliftest.domain.model.ImageEntity
import javax.inject.Inject

class ImageRepoImpl @Inject constructor(
    private val api: Api,
    private val dao: ImagesDao
) : ImageRepo {

    override suspend fun fetchData() = api.fetchData()

    override fun loadImages() = dao.loadImages()

    override suspend fun insert(vararg entity: ImageEntity) = dao.insertImages(*entity)

}