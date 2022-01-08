package zafar.abdulloev.aliftest.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import zafar.abdulloev.aliftest.GUIDE_DB_VERSION
import zafar.abdulloev.aliftest.data.model.Venue
import zafar.abdulloev.aliftest.domain.model.FullGuideEntity
import zafar.abdulloev.aliftest.domain.model.FullGuideWithVenue
import zafar.abdulloev.aliftest.domain.model.GuideEntity

@Database(
    version = GUIDE_DB_VERSION,
    entities = [GuideEntity::class, FullGuideEntity::class, Venue::class]
)
abstract class GuideDataBase : RoomDatabase() {
    abstract fun guidesDao(): GuideDao
}