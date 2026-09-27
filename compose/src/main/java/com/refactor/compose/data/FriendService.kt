package com.refactor.compose.data

import com.refactor.compose.domain.model.Friend
import retrofit2.http.GET

const val API_URL = "https://6ab64262c4c7bb67b918af50.mockapi.io/"

interface FriendService {
    @GET("friends")
    suspend fun getFriends(): List<Friend>
}

