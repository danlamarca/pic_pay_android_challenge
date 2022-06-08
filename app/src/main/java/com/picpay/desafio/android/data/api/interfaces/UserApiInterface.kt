package com.picpay.desafio.android.data.api.interfaces

import com.picpay.desafio.android.data.model.User
import retrofit2.http.GET

interface UserApiInterface {//implemented by datasource
    @GET("users")
    suspend fun getUsers(): List<User>
}