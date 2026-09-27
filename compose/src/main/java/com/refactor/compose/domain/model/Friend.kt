package com.refactor.compose.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class Friend(
    val createdAt: String,
    val avatar: String,
    val name: String,
    val id: String
) : Parcelable

