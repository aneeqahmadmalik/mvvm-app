package com.aneeque.mvvm_app.network

import com.aneeque.mvvm_app.constants.ServicesURLS
import com.aneeque.mvvm_app.services.PhotosServices
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofitClient: Retrofit.Builder by lazy {
        val levelType = Level.BODY

        val logging = HttpLoggingInterceptor()
        logging.setLevel(levelType)

        val okhttpClient = OkHttpClient.Builder()
        okhttpClient.addInterceptor(logging)

        Retrofit.Builder()
            .baseUrl(ServicesURLS.PHOTOS_BASE_URL)
            .client(okhttpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
    }

    val apiInterface: PhotosServices by lazy {
        retrofitClient
            .build()
            .create(PhotosServices::class.java)
    }
}