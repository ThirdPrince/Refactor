package com.refactor.compose.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.refactor.compose.ObjectInjector
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn

class MainViewModel : ViewModel() {

    val getFriendsUseCase by lazy { ObjectInjector.getFriendsUseCase }

    val uiState: StateFlow<MainUiState> = flow {
        getFriendsUseCase().fold(
            onSuccess = { friends ->
                val friendsListItems = friends.map { friend ->
                    FriendListItem(id = friend.id, name = friend.name, avatar = friend.avatar, createAt = friend.createdAt)
                }
                emit(MainUiState(friendsListItems = friendsListItems))
            },
            onFailure = {
                emit(MainUiState(friendsListItems = emptyList()))
            }
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = MainUiState(friendsListItems = emptyList())
    )
}

