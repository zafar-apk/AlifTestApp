package zafar.abdulloev.aliftest.domain.use_case.get_guides

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import zafar.abdulloev.aliftest.data.model.Resource
import zafar.abdulloev.aliftest.domain.model.GuideEntity

interface GetGuidesUseCase {

    suspend operator fun invoke(): Resource<Flow<PagingData<GuideEntity>>>

}