package br.com.agilles.iddog.retrofit.client

import br.com.agilles.iddog.model.Dog
import br.com.agilles.iddog.retrofit.RetrofitInitializer
import br.com.agilles.iddog.retrofit.callback

class DogWebClient {

    fun listDogs(token: String, category: String, success: (dog: Dog) -> Unit,
                 failure: (throwable: Throwable) -> Unit) {

        val call = RetrofitInitializer().dogService().listDogs(token, category)
        call.enqueue(callback({ response ->
            response?.body()?.let {
                success(it)
            }
        }, {
            it?.let {
                failure(it)
            }
        }))
//

    }
}