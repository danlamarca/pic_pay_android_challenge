package com.picpay.desafio.android.domain.usecase

import com.picpay.desafio.android.data.model.User

class UserUseCaseDomain(private val users: List<User>) {
    suspend operator fun invoke(): List<User>{
        return this.users.sortedBy { it.comparator() }
    }
}