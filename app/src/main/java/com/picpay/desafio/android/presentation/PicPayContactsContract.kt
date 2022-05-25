package com.picpay.desafio.android.presentation

import android.content.Context
import com.picpay.desafio.provider.model.User
import retrofit2.Response

interface PicPayContactsContract {

    interface View {
        fun inProcess()
        fun showError()
        fun showSuccess(users: List<User>)
        fun getContext(): Context
    }

    interface Presenter {
        fun showContacts()
    }
}