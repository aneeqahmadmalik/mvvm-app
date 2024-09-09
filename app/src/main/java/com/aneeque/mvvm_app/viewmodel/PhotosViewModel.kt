package com.aneeque.mvvm_app.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aneeque.mvvm_app.network.RetrofitInstance
import com.aneeque.mvvm_app.responses.PhotosResponseItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val TAG = "PhotosViewModelTAG"

class PhotosViewModel: ViewModel() {
    private var photosLiveData = MutableLiveData<Response<List<PhotosResponseItem>>>()

    fun getPhotos() {
        RetrofitInstance.apiService?.getPhotos()?.enqueue(object :
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
    }

    fun observePhotosLiveData(): LiveData<Response<List<PhotosResponseItem>>> {
        return photosLiveData
    }
}