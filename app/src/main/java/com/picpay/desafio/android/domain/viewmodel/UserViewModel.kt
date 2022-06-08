package com.picpay.desafio.android.domain.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.picpay.desafio.android.data.repository.UserRepository
import com.picpay.desafio.service.Utils.Resource
import kotlinx.coroutines.Dispatchers

class UserViewModel(private val userRepository: UserRepository): ViewModel() {
    fun getUsers() = liveData(Dispatchers.IO){
        emit(Resource.loading(data=null))
        try{
            emit(Resource.success(data = userRepository.getUsers()))
        }catch (ex: Exception){
            emit(Resource.error(data = null, message = "An error has ocurred: ${ex.message})"))
        }
    }
}