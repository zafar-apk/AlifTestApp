package zafar.abdulloev.aliftest.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import zafar.abdulloev.aliftest.IMAGE_DB_VERSION
import zafar.abdulloev.aliftest.domain.model.ImageEntity

@Database(version = IMAGE_DB_VERSION, entities = [ImageEntity::class])
abstract class ImageDataBase : RoomDatabase() {
    abstract fun imagesDao(): ImagesDao
}