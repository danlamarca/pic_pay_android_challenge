package com.picpay.desafio.android.data.repository

import android.util.Log
import com.picpay.desafio.android.data.datasource.UserDataSource
import com.picpay.desafio.android.data.model.UserDataModel
import com.picpay.desafio.android.domain.repository.UserDomainInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository(): UserDomainInterface{
    override fun showUsers(): List<UserDataModel> {
        var listUser: List<UserDataModel> = listOf()

        UserDataSource().getUsersDataSource()
            .enqueue(object : Callback<List<UserDataModel>> {
                override fun onFailure(call: Call<List<UserDataModel>>, t: Throwable) {
                    Log.e("User err.", "Failed to recover users")
                }

                override fun onResponse(
                    call: Call<List<UserDataModel>>,
                    response: Response<List<UserDataModel>>
                ) {
                    listUser = response.body()!!
                }
            })
        return listUser
    }

}