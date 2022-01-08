package zafar.abdulloev.aliftest.presenter.screens.master

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import zafar.abdulloev.aliftest.data.model.Resource
import zafar.abdulloev.aliftest.domain.screen_state.MainScreenState
import zafar.abdulloev.aliftest.domain.use_case.GetImagesUseCase
import javax.inject.Inject

@HiltViewModel
class MasterViewModel @Inject constructor(private val useCase: GetImagesUseCase) : ViewModel() {

    private val _screenState: MutableState<MainScreenState> =
        mutableStateOf(MainScreenState.Loading)
    val screenState: State<MainScreenState> = _screenState

    init {
        loadGuides()
    }

    fun loadGuides() {
        _screenState.value = MainScreenState.Loading

        viewModelScope.launch {
            _screenState.value = when (val response = useCase()) {
                Resource.Error -> MainScreenState.Error
                is Resource.Success -> MainScreenState.Success(data = response.content)
            }
        }
    }

}