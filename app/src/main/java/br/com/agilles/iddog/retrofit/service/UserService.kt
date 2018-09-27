package br.com.agilles.iddog.retrofit.service

import br.com.agilles.iddog.model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface UserService {
    @POST("signup")
    fun insertEmail(@Body user: User): Call<User>

}