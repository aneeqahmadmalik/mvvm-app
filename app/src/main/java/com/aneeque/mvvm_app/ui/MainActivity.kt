package com.aneeque.mvvm_app.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.aneeque.mvvm_app.helpers.ProgressHelper
import com.aneeque.mvvm_app.viewmodel.PhotosViewModel
import com.aneeque.mvvm_app.adapter.PhotosAdapter
import com.aneeque.mvvm_app.databinding.ActivityMainBinding

private const val TAG = "MainActivityTAG"

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var photosViewModel: PhotosViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        photosViewModel = ViewModelProvider(this)[PhotosViewModel::class.java]
        photosViewModel.getPhotos()
        ProgressHelper.showProgressDialog(this, "Loading...")
        photosViewModel.observePhotosLiveData().observe(this) { photosList ->
            if (photosList.isSuccessful) {
                ProgressHelper.dismissDialog()
                binding.rvPhotos.visibility = View.VISIBLE
                photosList.body()?.forEach { _ ->
                    binding.rvPhotos.apply {
                        layoutManager = LinearLayoutManager(this@MainActivity)
                        adapter = PhotosAdapter(this@MainActivity, photosList.body())
                    }
                }
            }
        }
    }
}