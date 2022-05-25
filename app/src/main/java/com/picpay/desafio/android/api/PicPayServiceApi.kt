package com.picpay.desafio.android.api

import com.picpay.desafio.provider.model.User
import retrofit2.Call
import retrofit2.http.GET


interface PicPayServiceApi {

   @GET("users")
   fun getUsers(): Call<List<User>>
}