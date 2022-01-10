package zafar.abdulloev.aliftest.presenter.screens.master

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import zafar.abdulloev.aliftest.data.model.Resource
import zafar.abdulloev.aliftest.domain.model.GuideEntity
import zafar.abdulloev.aliftest.domain.screen_state.ScreenState
import zafar.abdulloev.aliftest.domain.use_case.get_guides.GetGuidesUseCaseImpl
import javax.inject.Inject

private typealias MasterScreenState = ScreenState<Flow<PagingData<GuideEntity>>>

@HiltViewModel
class MasterViewModel @Inject constructor(private val useCase: GetGuidesUseCaseImpl) : ViewModel() {

    private val _screenState: MutableState<MasterScreenState> =
        mutableStateOf(ScreenState.Loading)
    val screenState: State<MasterScreenState> = _screenState

    init {
        loadGuides()
    }

    fun loadGuides() {
        _screenState.value = ScreenState.Loading

        viewModelScope.launch {
            _screenState.value = when (val response = useCase()) {
                Resource.Error -> ScreenState.Error
                is Resource.Success -> ScreenState.Success(data = response.content)
            }
        }
    }

}