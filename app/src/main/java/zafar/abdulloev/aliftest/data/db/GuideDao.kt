package zafar.abdulloev.aliftest.data.db

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import zafar.abdulloev.aliftest.domain.model.GuideEntity

@Dao
interface GuideDao {

    @Query("SELECT * FROM guide_table")
    fun getGuides(): PagingSource<Int, GuideEntity>

    @Query("SELECT COUNT(*) FROM guide_table")
    suspend fun getCount(): Int

    @Insert(onConflict = REPLACE)
    suspend fun insertGuides(vararg entity: GuideEntity)

}