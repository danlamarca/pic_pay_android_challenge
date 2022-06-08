package com.picpay.desafio.android.domain.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.picpay.desafio.android.data.datasource.UserDataSource
import com.picpay.desafio.android.data.repository.UserRepository

class UserViewModelFactory (private val userDataSource: UserDataSource) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(UserViewModel::class.java)){
            return UserViewModel(UserRepository(userDataSource)) as T
        }
        throw IllegalArgumentException("An error has occurred")
    }

}