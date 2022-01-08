package zafar.abdulloev.aliftest.domain.model

import zafar.abdulloev.aliftest.data.model.Image

fun Image.toEntity() = ImageEntity(
    endDate = endDate ?: "",
    icon = icon ?: "",
    name = name ?: "",
    startDate = startDate ?: "",
    url = url ?: ""
)