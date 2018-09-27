package br.com.agilles.iddog.retrofit

import br.com.agilles.iddog.retrofit.service.UserService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {

    private val retrofit = Retrofit.Builder()
            .baseUrl("https://api-iddog.idwall.co/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun userService() = retrofit.create(UserService::class.java)

}