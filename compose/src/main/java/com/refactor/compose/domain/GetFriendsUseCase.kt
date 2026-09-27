package com.refactor.compose.domain

import com.refactor.compose.domain.model.Friend

class GetFriendsUseCase(private val friendsRepository: FriendsRepository) {
    suspend operator fun invoke(): Result<List<Friend>> {
        return friendsRepository.getFriends()
    }
}
