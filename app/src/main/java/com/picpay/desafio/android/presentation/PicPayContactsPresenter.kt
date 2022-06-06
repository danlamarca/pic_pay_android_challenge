package com.picpay.desafio.android.presentation

import com.picpay.desafio.android.data.datasource.UserDataSource
import com.picpay.desafio.provider.model.CacheElement
import com.picpay.desafio.provider.model.ResponseUser
import com.picpay.desafio.android.data.model.User
import com.picpay.desafio.provider.model.ProviderUser
import com.picpay.desafio.service.singleton.Cache
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PicPayContactsPresenter(val view: PicPayContactsContract.View) :
    PicPayContactsContract.Presenter {

    init {
        view.inProcess()
    }

    override fun showContacts() {
        //cash verification
        val cash =
            Cache(view.getContext()).getSavedFilesInDisc(CacheElement.Companion.cacheType.CONTACTSCACHE)

        if (cash == null) {
            executeCallback()
        } else {
            cash?.providerUsers?.let { view.showSuccess(it) }
        }
    }

    private fun executeCallback() {
        UserDataSource().getUsers()
            .enqueue(object : Callback<List<User>> {
                override fun onFailure(call: Call<List<User>>, t: Throwable) {
                    view.showError()
                }

                override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                    val listUsers: List<User> = response.body()!!

                    Cache(view.getContext()).saveFilesInDisc(
                        CacheElement.Companion.cacheType.CONTACTSCACHE,
                        ResponseUser(
                            listUsers as List<ProviderUser>
                        )
                    )
                    view.showSuccess(listUsers)
                }
            })
    }
}