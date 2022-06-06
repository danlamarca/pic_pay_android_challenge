package com.picpay.desafio.android.presentation

import android.content.Context
import com.picpay.desafio.provider.model.ProviderUser

interface PicPayContactsContract {

    interface View {
        fun inProcess()
        fun showError()
        fun showSuccess(users: List<ProviderUser>)
        fun getContext(): Context
    }

    interface Presenter {
        fun showContacts()
    }
}