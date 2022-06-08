package com.picpay.desafio.android.domain.repository

import com.picpay.desafio.android.data.model.User

interface UserDomainInterface {
    fun showUsers(): List<User>
}