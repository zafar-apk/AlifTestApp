package zafar.abdulloev.aliftest.data.model

sealed class Resource<out T> {
    object Error : Resource<Nothing>()
    class Success<T>(content: T) : Resource<T>()
}