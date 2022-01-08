package zafar.abdulloev.aliftest.domain.model

import zafar.abdulloev.aliftest.data.model.BaseGuide
import zafar.abdulloev.aliftest.data.model.Guide

fun BaseGuide.toEntity() = GuideEntity(
    endDate = endDate ?: "",
    icon = icon ?: "",
    name = name ?: "",
    startDate = startDate ?: "",
    url = url ?: ""
)

fun Guide.toEntity() = FullGuideEntity(
    bundleVersion = bundleVersion,
    endDate = endDate,
    gbUrl = gbUrl,
    guideVersion = guideVersion,
    icon = icon,
    id = id,
    inviteOnly = inviteOnly,
    loginRequired = loginRequired,
    minAppVersionAndroid = minAppVersionAndroid,
    minAppVersionIOS = minAppVersionIOS,
    name = name,
    ownerId = ownerId,
    productIdentifier = productIdentifier,
    startDate = startDate,
    type = type,
)