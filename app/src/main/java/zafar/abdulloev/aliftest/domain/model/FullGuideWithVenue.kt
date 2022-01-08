package zafar.abdulloev.aliftest.domain.model


import androidx.room.Embedded
import androidx.room.Relation
import zafar.abdulloev.aliftest.data.model.Venue

class FullGuideWithVenue(
    @Embedded
    val fullGuideEntity: FullGuideEntity,
    @Relation(parentColumn = "id", entityColumn = "guideId", entity = Venue::class)
    val venue: Venue? = null
)