package com.aneeque.mvvm_app.services

import com.aneeque.mvvm_app.responses.PhotosResponseItem
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface PhotosServices {
    @GET("/photos")
    suspend fun getPhotos(): Response<List<PhotosResponseItem>>
}