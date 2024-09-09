package com.aneeque.mvvm_app.responses

data class PhotosResponseItem(
    val albumId: Long,
    val id: Long,
    val thumbnailUrl: String,
    val title: String,
    val url: String
)