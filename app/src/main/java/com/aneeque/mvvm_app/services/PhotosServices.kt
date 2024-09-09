package com.aneeque.mvvm_app.services

import com.aneeque.mvvm_app.responses.PhotosResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface PhotosServices {
    @GET("/photos")
    fun getPhotos(): Call<List<PhotosResponseItem>>
}