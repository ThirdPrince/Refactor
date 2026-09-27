package com.refactor.compose.domain

import com.refactor.compose.domain.model.Friend

interface FriendsRepository {
    suspend fun getFriends(): Result<List<Friend>>
}