package com.picpay.desafio.android.data.api

import com.picpay.desafio.service.RestApi
import retrofit2.Retrofit

class Api() {
    companion object {
        fun getRetrofitInstance(): Retrofit {//returns service module with retrofit object
            return RestApi.getRetrofit()
        }
    }
}