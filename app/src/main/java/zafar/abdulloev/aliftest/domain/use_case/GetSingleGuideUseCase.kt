package zafar.abdulloev.aliftest.domain.use_case

import zafar.abdulloev.aliftest.data.model.Resource
import zafar.abdulloev.aliftest.data.repo.interfaces.GuidesRepo
import zafar.abdulloev.aliftest.domain.model.FullGuideWithVenue
import zafar.abdulloev.aliftest.domain.model.toEntity
import javax.inject.Inject

class GetSingleGuideUseCase @Inject constructor(private val repo: GuidesRepo) {

    suspend operator fun invoke(id: String): Resource<FullGuideWithVenue> {
        val fromDb = repo.getSingleGuideFromDB(id)
        if (fromDb == null) {
            getFromNetwork(id)?.let {
                repo.insertFullGuideToDB(it)
            }
        } else return Resource.Success(fromDb)

        return repo.getSingleGuideFromDB(id)?.let {
            Resource.Success(it)
        }
            ?: Resource.Error
    }

    private suspend fun getFromNetwork(url: String): FullGuideWithVenue? {
        var fullGuideWithVenue: FullGuideWithVenue? = null
        return kotlin.runCatching {
            val response = repo.getSingleGuideFromNetwork(url)
            if (response.isSuccessful) {
                val fullGuide = response.body()!!
                val fullGuideEntity = fullGuide.toEntity()
                fullGuideWithVenue = FullGuideWithVenue(fullGuideEntity, fullGuide.venue)
            }
            return fullGuideWithVenue
        }.getOrNull()
    }

}