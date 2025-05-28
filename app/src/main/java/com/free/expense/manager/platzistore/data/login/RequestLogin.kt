package com.free.expense.manager.platzistore.data.login


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class RequestLogin(
    @SerializedName("email")
    var email: String?,
    @SerializedName("password")
    var password: String?
)