package zafar.abdulloev.aliftest.domain.model

import zafar.abdulloev.aliftest.data.model.BaseGuide

fun BaseGuide.toEntity() = GuideEntity(
    endDate = endDate ?: "",
    icon = icon ?: "",
    name = name ?: "",
    startDate = startDate ?: "",
    url = url ?: ""
)