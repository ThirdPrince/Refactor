package com.refactor.compose.ui

data class FriendListItem(val id: String, val name: String, val avatar: String, val createAt: String)

data class MainUiState(val friendsListItems: List<FriendListItem>)