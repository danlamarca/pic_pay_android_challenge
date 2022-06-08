package com.picpay.desafio.android.data.repository

import com.picpay.desafio.android.data.datasource.UserDataSource

class UserRepository(private val userDataSource: UserDataSource){
    suspend fun getUsers() = userDataSource.getUser()
}