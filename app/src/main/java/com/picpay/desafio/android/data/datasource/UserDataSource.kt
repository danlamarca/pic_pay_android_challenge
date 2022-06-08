package com.picpay.desafio.android.data.datasource

import com.picpay.desafio.android.data.api.interfaces.UserApiInterface

class UserDataSource(private val userApiInterface: UserApiInterface) {
    suspend fun getUser() = userApiInterface.getUsers()
}