package zafar.abdulloev.aliftest.data.remote_mediator

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import zafar.abdulloev.aliftest.domain.model.GuideEntity

@OptIn(ExperimentalPagingApi::class)
class GuideRemoteMediator : RemoteMediator<Int, GuideEntity>() {
    override suspend fun initialize(): InitializeAction {
        return super.initialize()
    }
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, GuideEntity>
    ): MediatorResult {
        TODO("Not yet implemented")
    }
}