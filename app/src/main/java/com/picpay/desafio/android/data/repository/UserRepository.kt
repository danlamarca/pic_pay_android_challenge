package com.picpay.desafio.android.data.repository

import com.picpay.desafio.android.data.datasource.UserDataSource
import com.picpay.desafio.android.data.model.UserDataModel
import com.picpay.desafio.android.domain.repository.UserDomainInterface
import retrofit2.Call

class UserRepository(): UserDomainInterface{
    override fun showUsers(): Call<List<UserDataModel>> {
        return UserDataSource().getUsers()
    }

}