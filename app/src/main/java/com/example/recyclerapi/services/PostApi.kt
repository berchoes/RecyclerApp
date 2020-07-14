package com.example.recyclerapi.services

import com.example.recyclerapi.models.AircraftResponse
import com.example.recyclerapi.models.PostModel
import com.example.recyclerapi.models.UserModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface PostApi {
    @GET("/posts")
    fun getPosts(): Call<List<PostModel>>

    @GET("/users")
    fun getUsers(): Call<List<UserModel>>

    @Headers(
        "Accept: application/json",
        "app_id: 757b9e27",
        "app_key: 0dcd8b3a590f2dbd6414c2ff2513394a",
        "ResourceVersion: v4"
    )
    @GET("/public-flights/aircrafttypes?")
    fun getPlanes(@Query("page") pageNum: Int ): Call<AircraftResponse>
}