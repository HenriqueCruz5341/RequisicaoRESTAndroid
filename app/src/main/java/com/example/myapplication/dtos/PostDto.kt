package com.example.myapplication.dtos

import com.google.gson.annotations.SerializedName

class PostDto {

    @SerializedName("userId")
    var userID: Int = 0

    @SerializedName("id")
    var id: Int = 0

    @SerializedName("title")
    var title: String = ""

    @SerializedName("body")
    var body: String = ""

}