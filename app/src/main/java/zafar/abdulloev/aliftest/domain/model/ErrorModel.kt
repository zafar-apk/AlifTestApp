package zafar.abdulloev.aliftest.domain.model

data class ErrorModel(
    val isError: Boolean = false,
    val action: () -> Unit = {

    }
)