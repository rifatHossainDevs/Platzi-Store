package com.free.expense.manager.platzistore.data.repository

import com.free.expense.manager.platzistore.data.login.RequestLogin
import com.free.expense.manager.platzistore.data.login.ResponseLogin
import com.free.expense.manager.platzistore.servises.AuthService
import retrofit2.Response
import javax.inject.Inject

class AuthRepository @Inject constructor(private val service: AuthService) {

    suspend fun login(requestLogin: RequestLogin): Response<ResponseLogin> {
        return service.login(requestLogin)
    }

}