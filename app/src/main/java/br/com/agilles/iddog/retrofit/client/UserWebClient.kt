package br.com.agilles.iddog.retrofit.client

import br.com.agilles.iddog.model.Dog
import br.com.agilles.iddog.model.EmailResponse
import br.com.agilles.iddog.model.User
import br.com.agilles.iddog.retrofit.RetrofitInitializer
import br.com.agilles.iddog.retrofit.callback

class UserWebClient {

    fun addEmail(user: User, success: (emailResponse: EmailResponse) -> Unit,
                 failure: (throwable: Throwable) -> Unit) {

        val call = RetrofitInitializer().userService().insertEmail(user)
        call.enqueue(callback({ response ->
            response?.body()?.let {
                success(it)

            }
        }, { throwable ->
            throwable?.let {
                failure(it)
            }

        }))
    }

    fun enter(token: String, category: String, success: (dog: Dog) -> Unit,
              failure: (throwable: Throwable) -> Unit) {

        val call = RetrofitInitializer().userService().enter(token, category)

        call.enqueue(callback({ response ->
            response?.body()?.let {
                success(it)

            }
        }, {
            it?.let {
                failure(it)
            }
        }

        ))

    }

}