package com.picpay.desafio.android.presentation

import android.content.Context
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.picpay.desafio.android.R
import com.picpay.desafio.android.presentation.adapter.UserListAdapter
import com.picpay.desafio.android.data.model.User

open class PicPayContactsActivity : AppCompatActivity(R.layout.activity_main),
    PicPayContactsContract.View {
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var adapter: UserListAdapter
    private lateinit var presenter: PicPayContactsPresenter

    override fun onResume() {
        super.onResume()

        recyclerView = findViewById(R.id.recyclerView)
        progressBar = findViewById(R.id.user_list_progress_bar)

        adapter = UserListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        presenter = PicPayContactsPresenter(this)
        presenter.showContacts()
    }

    override fun inProcess() {
        progressBar.visibility = View.VISIBLE
    }

    override fun showError() {
        val message = getString(R.string.error)

        progressBar.visibility = View.GONE
        recyclerView.visibility = View.GONE

        Toast.makeText(progressBar.context, message, Toast.LENGTH_SHORT)
            .show()
    }

    override fun showSuccess(users: List<User>) {
        progressBar.visibility = View.GONE
        if (users.isNullOrEmpty())
            return

        adapter.users = users as List<User>//users.sortedBy { it.comparator() }
    }

    override fun getContext(): Context {
        return this.applicationContext
    }

}