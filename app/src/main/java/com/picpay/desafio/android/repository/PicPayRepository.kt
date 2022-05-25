package com.picpay.desafio.android.repository

import com.picpay.desafio.android.api.PicPayServiceApi
import com.picpay.desafio.provider.model.User
import com.picpay.desafio.service.RestApi
import retrofit2.Call

class PicPayRepository {

    val api: PicPayServiceApi = RestApi.getRetrofit().create(PicPayServiceApi::class.java)

    fun getUsers(): Call<List<User>> {
        return api.getUsers()
    }
}