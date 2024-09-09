package com.aneeque.mvvm_app.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aneeque.mvvm_app.repository.PhotosRepository
import com.aneeque.mvvm_app.responses.PhotosResponseItem
import retrofit2.Response

private const val TAG = "PhotosViewModelTAG"

class PhotosViewModel(private val repo: PhotosRepository) : ViewModel() {
    private var photosLiveData = MutableLiveData<Response<List<PhotosResponseItem>>>()

//    suspend fun observePhotosLiveData(): LiveData<Response<List<PhotosResponseItem>>> {
//        photosLiveData = repo.getPhotos()
//        return photosLiveData
//    }
}