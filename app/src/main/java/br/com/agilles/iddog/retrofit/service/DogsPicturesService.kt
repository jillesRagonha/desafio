package br.com.agilles.iddog.retrofit.service

import br.com.agilles.iddog.model.Dog
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface DogsPicturesService {

    @GET("feed")
    fun listDogs(@Header("Authorization")token:String,
                 @Query("category")category:String): Call<Dog>
}