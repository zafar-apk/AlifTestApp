package zafar.abdulloev.aliftest.domain.screen_state

sealed class ScreenState<out T> {
    object Loading : ScreenState<Nothing>()
    object Error : ScreenState<Nothing>()
    class Success<T>(val data: T) : ScreenState<T>()
}