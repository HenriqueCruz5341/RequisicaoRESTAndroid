package com.example.myapplication.services

import com.example.myapplication.dtos.PostDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PostService {

    @GET("posts")
    fun getAllBlogPosts(): Call<List<PostDto>>

    @GET("posts/{postId}")
    fun getSinglePost(@Path("postId")postId: Int): Call<PostDto>

}