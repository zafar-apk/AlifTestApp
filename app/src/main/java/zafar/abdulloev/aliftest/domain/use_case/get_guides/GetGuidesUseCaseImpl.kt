package zafar.abdulloev.aliftest.domain.use_case.get_guides

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import zafar.abdulloev.aliftest.PAGE_SIZE
import zafar.abdulloev.aliftest.data.model.Resource
import zafar.abdulloev.aliftest.data.repo.interfaces.GuidesRepo
import zafar.abdulloev.aliftest.domain.model.GuideEntity
import zafar.abdulloev.aliftest.domain.model.toEntity
import javax.inject.Inject

class GetGuidesUseCaseImpl @Inject constructor(private val repo: GuidesRepo) : GetGuidesUseCase {

    override suspend operator fun invoke(): Resource<Flow<PagingData<GuideEntity>>> {
        if (repo.getCountInDB() == 0) {
            if (!getFromNetwork()) {
                return Resource.Error
            }
        }

        return getPagingFlowFromDB()
    }

    private fun getPagingFlowFromDB(): Resource<Flow<PagingData<GuideEntity>>> {
        val config = PagingConfig(
            pageSize = PAGE_SIZE,
            enablePlaceholders = false
        )

        val pagingFlow = Pager(config, null) {
            repo.getGuidesFromDB()
        }.flow
        return Resource.Success(pagingFlow)
    }

    private suspend fun getFromNetwork(): Boolean {
        return kotlin.runCatching {
            fillDataBaseWithException()
        }.isSuccess
    }

    private suspend fun fillDataBaseWithException() {
        val data = repo.getGuidesFromNetwork().body()?.data!!
        val guidesList = data.map { it.toEntity() }
        repo.insertToDB(*guidesList.toTypedArray())
    }

}