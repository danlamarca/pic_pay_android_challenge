package com.picpay.desafio.provider.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.picpay.desafio.provider.utils.Extensions.unaccent
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProviderUser(
    @SerializedName("img") var img: String,
    @SerializedName("name") var name: String,
    @SerializedName("id") var id: Int,
    @SerializedName("username") var username: String
) : Parcelable