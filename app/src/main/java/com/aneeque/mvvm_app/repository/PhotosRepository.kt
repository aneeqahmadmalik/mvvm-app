package com.aneeque.mvvm_app.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.aneeque.mvvm_app.network.RetrofitInstance
import com.aneeque.mvvm_app.responses.PhotosResponseItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val TAG = "PhotosRepositoryTAG"

object PhotosRepository {
    private var photosLiveData = MutableLiveData<Response<List<PhotosResponseItem>>>()

    fun getPhotos(): MutableLiveData<Response<List<PhotosResponseItem>>> {
        val call = RetrofitInstance.apiInterface.getPhotos()

        call.enqueue(object :
            Callback<List<PhotosResponseItem>> {
            override fun onResponse(
                call: Call<List<PhotosResponseItem>>,
                response: Response<List<PhotosResponseItem>>
            ) {
                if (response.isSuccessful) {
                    Log.e(TAG, "response: $response")
                    photosLiveData.value = response
                }
            }

            override fun onFailure(p0: Call<List<PhotosResponseItem>>, t: Throwable) {
                Log.e(TAG, "ERROR MESSAGE: ${t.message}")
                photosLiveData.value = null
            }
        })

        return photosLiveData
    }
}