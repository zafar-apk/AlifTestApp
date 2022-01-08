package zafar.abdulloev.aliftest.data.api.impl

import zafar.abdulloev.aliftest.data.api.Api
import zafar.abdulloev.aliftest.data.api.interfaces.ImageRepo
import javax.inject.Inject

class ImageRepoImpl @Inject constructor(private val api: Api) : ImageRepo {
    override suspend fun fetchData() = api.fetchData()
}