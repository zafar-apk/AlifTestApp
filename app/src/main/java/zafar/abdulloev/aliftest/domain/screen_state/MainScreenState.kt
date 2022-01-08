package zafar.abdulloev.aliftest.domain.screen_state

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import zafar.abdulloev.aliftest.domain.model.GuideEntity

sealed class MainScreenState {
    object Loading : MainScreenState()
    object Error : MainScreenState()
    class Success(val data: Flow<PagingData<GuideEntity>>) : MainScreenState()
}