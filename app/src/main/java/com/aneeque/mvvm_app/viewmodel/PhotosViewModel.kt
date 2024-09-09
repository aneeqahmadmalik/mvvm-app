package com.aneeque.mvvm_app.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aneeque.mvvm_app.repository.PhotosRepository
import com.aneeque.mvvm_app.responses.PhotosResponseItem
import retrofit2.Response

private const val TAG = "PhotosViewModelTAG"

class PhotosViewModel : ViewModel() {
    private var photosLiveData = MutableLiveData<Response<List<PhotosResponseItem>>>()

    fun observePhotosLiveData(): LiveData<Response<List<PhotosResponseItem>>> {
        photosLiveData = PhotosRepository.getPhotos()
        return photosLiveData
    }
}