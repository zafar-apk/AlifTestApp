package zafar.abdulloev.aliftest.presenter.screens.details

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import zafar.abdulloev.aliftest.GUIDE_URL
import zafar.abdulloev.aliftest.data.model.Resource
import zafar.abdulloev.aliftest.domain.model.FullGuideWithVenue
import zafar.abdulloev.aliftest.domain.screen_state.ScreenState
import zafar.abdulloev.aliftest.domain.use_case.get_single_guide.GetSingleGuideUseCaseImpl
import javax.inject.Inject


@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val useCase: GetSingleGuideUseCaseImpl,
    private val stateHandle: SavedStateHandle
) : ViewModel() {

    private val _screenState: MutableState<ScreenState<FullGuideWithVenue>> =
        mutableStateOf(ScreenState.Loading)
    val screenState: State<ScreenState<FullGuideWithVenue>> = _screenState

    init {
        laodSingleGuide()
    }

    fun laodSingleGuide() {
        stateHandle.get<String>(GUIDE_URL)?.let { url ->
            _screenState.value = ScreenState.Loading

            viewModelScope.launch {
                _screenState.value = when (val response = useCase(url)) {
                    Resource.Error -> ScreenState.Error
                    is Resource.Success -> ScreenState.Success(data = response.content)
                }
            }
        }
    }

}