package com.example.jayghodasara.retrofit

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface Repos{

    @GET("/users/{user}/repos")
    fun getusers(@Path("user") user:String):Call<List<Pojo>>

    @POST("/posts")
    fun createacc(@Body() post:Postpojo):Call<Postpojo>
}