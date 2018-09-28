package br.com.agilles.iddog.model

import com.google.gson.annotations.SerializedName

class Dog(
        val category: String,
       @SerializedName("list") val imagesUrl: List<String>)