package com.picpay.desafio.android.presentation

import com.picpay.desafio.android.repository.PicPayRepository
import com.picpay.desafio.provider.model.CacheElement
import com.picpay.desafio.provider.model.ResponseUser
import com.picpay.desafio.provider.model.User
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
            cash?.users?.let { view.showSuccess(it) }
        }
    }

    private fun executeCallback() {
        PicPayRepository().getUsers()
            .enqueue(object : Callback<List<User>> {
                override fun onFailure(call: Call<List<User>>, t: Throwable) {
                    view.showError()
                }

                override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                    val listUsers: List<User> = response.body()!!
                    Cache(view.getContext()).saveFilesInDisc(
                        CacheElement.Companion.cacheType.CONTACTSCACHE,
                        ResponseUser(listUsers)
                    )
                    view.showSuccess(listUsers)
                }
            })
    }
}