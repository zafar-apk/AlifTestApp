package zafar.abdulloev.aliftest.data.db

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Transaction
import zafar.abdulloev.aliftest.data.model.Venue
import zafar.abdulloev.aliftest.domain.model.FullGuideEntity
import zafar.abdulloev.aliftest.domain.model.FullGuideWithVenue
import zafar.abdulloev.aliftest.domain.model.GuideEntity

@Dao
interface GuideDao {

    @Query("SELECT * FROM guide_table")
    fun getGuides(): PagingSource<Int, GuideEntity>

    @Query("SELECT COUNT(*) FROM guide_table")
    suspend fun getCount(): Int

    @Insert(onConflict = REPLACE)
    suspend fun insertGuides(vararg entity: GuideEntity)

    @Insert(onConflict = REPLACE)
    suspend fun insertFullGuide(entity: FullGuideEntity)

    @Insert(onConflict = REPLACE)
    suspend fun insertVenue(entity: Venue)

    @Transaction
    suspend fun insertFullGuide(entity: FullGuideWithVenue) {
        insertFullGuide(entity.fullGuideEntity)
        val venue = entity.venue?.copy(guideId = entity.fullGuideEntity.id!!)
        venue?.let { insertVenue(it) }
    }

    @Transaction
    @Query("SELECT * FROM full_guide_table WHERE id = :id")
    suspend fun getSingleGuide(id: String): FullGuideWithVenue?

}