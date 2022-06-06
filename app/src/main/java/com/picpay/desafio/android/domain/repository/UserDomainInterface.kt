package com.picpay.desafio.android.domain.repository

import com.picpay.desafio.android.data.model.UserDataModel
import retrofit2.Call

interface UserDomainInterface {
    fun showUsers(): Call<List<UserDataModel>>
}