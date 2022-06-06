package com.picpay.desafio.android.data.api.interfaces

import com.picpay.desafio.android.data.model.UserDataModel
import retrofit2.Call
import retrofit2.http.GET

interface UserApiInterface {//implemented by datasource
    @GET("users")
    fun getUsersDataSource(): Call<List<UserDataModel>>
}