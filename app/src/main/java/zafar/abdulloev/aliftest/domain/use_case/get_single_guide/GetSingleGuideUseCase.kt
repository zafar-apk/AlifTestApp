package zafar.abdulloev.aliftest.domain.use_case.get_single_guide

import zafar.abdulloev.aliftest.data.model.Resource
import zafar.abdulloev.aliftest.domain.model.FullGuideWithVenue

interface GetSingleGuideUseCase {

    suspend operator fun invoke(id: String): Resource<FullGuideWithVenue>

}