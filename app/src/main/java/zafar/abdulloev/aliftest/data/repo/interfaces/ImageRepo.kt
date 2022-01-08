package zafar.abdulloev.aliftest.data.repo.interfaces

import androidx.paging.PagingSource
import retrofit2.Response
import zafar.abdulloev.aliftest.data.model.ImageResponse
import zafar.abdulloev.aliftest.domain.model.ImageEntity

interface ImageRepo {

    suspend fun fetchData(): Response<ImageResponse>

    fun loadImages(): PagingSource<Int, ImageEntity>

    suspend fun insert(vararg entity: ImageEntity)

}