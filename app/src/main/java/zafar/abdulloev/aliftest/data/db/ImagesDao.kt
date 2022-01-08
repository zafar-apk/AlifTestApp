package zafar.abdulloev.aliftest.data.db

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import zafar.abdulloev.aliftest.domain.model.ImageEntity

@Dao
interface ImagesDao {

    @Query("SELECT * FROM image_table")
    fun loadImages(): PagingSource<Int, ImageEntity>

    @Insert(onConflict = REPLACE)
    suspend fun insertImages(vararg entity: ImageEntity)

}