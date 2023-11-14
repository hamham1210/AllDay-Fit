package com.example.alldayfit.community.model

import android.provider.ContactsContract.CommonDataKinds.Nickname

data class CommunityPostEntity(
    val postId: String,
    val title: String,
    val postingDate: String,
    val nickname: String,
    val content: String,
)