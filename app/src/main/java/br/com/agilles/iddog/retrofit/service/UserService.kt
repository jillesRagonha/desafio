package br.com.agilles.iddog.retrofit.service

import br.com.agilles.iddog.model.Dog
import br.com.agilles.iddog.model.EmailResponse
import br.com.agilles.iddog.model.User
import retrofit2.Call
import retrofit2.http.*

interface UserService {
    @POST("signup")
    fun insertEmail(@Body user: User): Call<EmailResponse>

    @GET("feed")
    fun enter(@Header("Authorization")token:String,
              @Query("category")category:String): Call<Dog>


}