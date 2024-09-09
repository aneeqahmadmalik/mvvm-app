package com.aneeque.mvvm_app.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.aneeque.mvvm_app.adapter.PhotosAdapter
import com.aneeque.mvvm_app.databinding.ActivityMainBinding
import com.aneeque.mvvm_app.helpers.ProgressHelper
import com.aneeque.mvvm_app.network.RetrofitInstance
import com.aneeque.mvvm_app.responses.PhotosResponseItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

private const val TAG = "MainActivityTAG"

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var response: Response<List<PhotosResponseItem>>? = null
        ProgressHelper.showProgressDialog(this@MainActivity, "Fetching photos from server")
        CoroutineScope(Dispatchers.IO).launch {
            response = RetrofitInstance.apiInterface.getPhotos()
            withContext(Dispatchers.Main) {
                if (response?.isSuccessful == true && response?.body()?.isNotEmpty() == true) {
                    ProgressHelper.dismissDialog()
                    binding.rvPhotos.visibility = View.VISIBLE
                    binding.rvPhotos.apply {
                        layoutManager = LinearLayoutManager(this@MainActivity)
                        adapter = PhotosAdapter(this@MainActivity, response?.body())
                    }
                }
            }
        }
    }
}