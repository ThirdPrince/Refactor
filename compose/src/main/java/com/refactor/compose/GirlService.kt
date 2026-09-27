package com.refactor.compose

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable
import retrofit2.http.GET

const val API_URL = "https://6ab64262c4c7bb67b918af50.mockapi.io/"

interface GirlService {
    @GET("friends")
    suspend fun getGirls(): List<Friends>
}

@Serializable
@Parcelize
data class Friends(
    val createdAt: String,
    val name: String,
    val avatar: String,
    val id: String
) : Parcelable
