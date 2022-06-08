package com.picpay.desafio.android.presentation

import android.content.Context
import com.picpay.desafio.android.data.model.User
import com.picpay.desafio.provider.model.ProviderUser

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