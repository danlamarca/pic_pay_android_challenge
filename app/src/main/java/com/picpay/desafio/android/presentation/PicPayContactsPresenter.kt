package com.picpay.desafio.android.presentation

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.picpay.desafio.android.data.api.RetrofitBuilder
import com.picpay.desafio.android.data.datasource.UserDataSource
import com.picpay.desafio.android.domain.viewmodel.UserViewModel
import com.picpay.desafio.android.domain.viewmodel.UserViewModelFactory
import com.picpay.desafio.service.Utils.Status

class PicPayContactsPresenter(private val activityInstance: PicPayContactsActivity) :

    PicPayContactsContract.Presenter {

    private val userViewModel: UserViewModel = ViewModelProvider(activityInstance,
        UserViewModelFactory(UserDataSource(RetrofitBuilder.userApiService))).get(UserViewModel::class.java)

    override fun showContacts() {
        executeCallback()
    }

    private fun executeCallback() {
        userViewModel.getUsers().observe(activityInstance, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                       resource.data?.let { users -> activityInstance.showSuccess(users) }
                    }
                    Status.ERROR -> {
                        activityInstance.showError()
                    }
                    Status.LOADING -> {
                        activityInstance.inProcess()
                    }
                }
            }
        })
    }
}