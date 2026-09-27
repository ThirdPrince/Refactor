package com.refactor.compose.data

import com.refactor.compose.domain.FriendsRepository
import com.refactor.compose.domain.model.Friend

class FriendsRepositoryImpl: FriendsRepository {
    override suspend fun getFriends(): Result<List<Friend>> {
        try {
            val friends = NetworkModule.friendService.getFriends()
            return Result.success(friends)
        } catch (e: Exception) {
            return Result.failure(e)
        }
    }
}