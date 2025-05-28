package com.free.expense.manager.platzistore.servises

import com.free.expense.manager.platzistore.data.login.RequestLogin
import com.free.expense.manager.platzistore.data.login.ResponseLogin
import retrofit2.Response

interface AuthService {
    fun login(requestLogin: RequestLogin): Response<ResponseLogin>
}