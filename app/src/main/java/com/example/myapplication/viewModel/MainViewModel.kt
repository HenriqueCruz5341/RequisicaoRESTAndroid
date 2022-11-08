package com.example.mvvm.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.dtos.PostDto
import com.example.myapplication.providers.ClientRetrofitProvider
import com.example.myapplication.services.PostService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    private var textView = MutableLiveData<String>()

    fun getTextView() : LiveData<String> {
        return textView
    }

    fun requestNewPost(postId: Int) {
        val apiBlogService = ClientRetrofitProvider.createService(PostService::class.java)
        val blogPost: Call<PostDto> = apiBlogService.getSinglePost(postId)

        blogPost.enqueue(object : Callback<PostDto> {
            override fun onResponse(call: Call<PostDto>, response: Response<PostDto>) {
                textView.value = response.body()?.body
            }

            override fun onFailure(call: Call<PostDto>, t: Throwable) {
                textView.value = "Falha na requisição da API"
            }

        })

    }

}