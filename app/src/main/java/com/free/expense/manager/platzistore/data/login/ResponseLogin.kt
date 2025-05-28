package com.free.expense.manager.platzistore.data.login


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class ResponseLogin(
    @SerializedName("access_token")
    var accessToken: String?,
    @SerializedName("refresh_token")
    var refreshToken: String?
)