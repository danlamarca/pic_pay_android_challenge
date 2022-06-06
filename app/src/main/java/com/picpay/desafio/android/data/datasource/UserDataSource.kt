package com.picpay.desafio.android.data.datasource

import com.picpay.desafio.android.data.api.Api
import com.picpay.desafio.android.data.api.interfaces.UserApiInterface
import com.picpay.desafio.android.data.model.UserDataModel
import retrofit2.Call

class UserDataSource():
    UserApiInterface {
    override fun getUsers(): Call<List<UserDataModel>> {
        val api = Api.getRetrofitInstance().create(UserApiInterface::class.java)
        return api.getUsers()
    }
}