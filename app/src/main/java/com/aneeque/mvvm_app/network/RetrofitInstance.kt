package com.aneeque.mvvm_app.network

import com.aneeque.mvvm_app.services.PhotosServices
import com.aneeque.mvvm_app.constants.ServicesURLS
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofitBuilder: Retrofit? = Retrofit
        .Builder()
        .baseUrl(ServicesURLS.PHOTOS_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService by lazy {
        retrofitBuilder?.create(PhotosServices::class.java)
    }
}