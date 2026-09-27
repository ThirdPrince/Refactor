package com.refactor.compose

import com.refactor.compose.data.FriendsRepositoryImpl
import com.refactor.compose.domain.GetFriendsUseCase

object ObjectInjector {
    val friendsRepository by lazy { FriendsRepositoryImpl() }

    val getFriendsUseCase by lazy { GetFriendsUseCase(friendsRepository) }
}