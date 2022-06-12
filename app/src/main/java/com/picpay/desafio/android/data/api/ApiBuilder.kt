package com.picpay.desafio.android.data.api

import com.picpay.desafio.android.data.api.interfaces.UserApiInterface
import com.picpay.desafio.service.RetrofitApi

object ApiBuilder {
        val userApiService: UserApiInterface =  RetrofitApi.getRetrofit().create(UserApiInterface::class.java)
}