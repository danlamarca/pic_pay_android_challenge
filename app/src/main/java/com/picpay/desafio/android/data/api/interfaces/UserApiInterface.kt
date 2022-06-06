package com.picpay.desafio.android.data.api.interfaces

import com.picpay.desafio.android.data.model.UserModel
import retrofit2.Call
import retrofit2.http.GET

interface UserApiInterface {//implemented by datasource
    @GET("users")
    fun getUsers(): Call<List<UserModel>>
}