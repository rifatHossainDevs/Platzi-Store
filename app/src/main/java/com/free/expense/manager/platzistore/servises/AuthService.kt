package com.free.expense.manager.platzistore.servises

import com.free.expense.manager.platzistore.data.login.RequestLogin
import com.free.expense.manager.platzistore.data.login.ResponseLogin
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("auth/login")
    suspend fun login(@Body requestLogin: RequestLogin): Response<ResponseLogin>
}