package com.picpay.desafio.android.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.picpay.desafio.provider.utils.Extensions.unaccent
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserModel(
    @SerializedName("img") var img: String,
    @SerializedName("name") var name: String,
    @SerializedName("id") var id: Int,
    @SerializedName("username") var username: String
) : Parcelable {

    fun comparator(): Int {
        return if(this.username.unaccent().first().toUpperCase().isLetter())
            this.username.unaccent().first().toUpperCase().toInt()
        else
            this.username.first().toInt() + 'z'.toInt()
    }
}