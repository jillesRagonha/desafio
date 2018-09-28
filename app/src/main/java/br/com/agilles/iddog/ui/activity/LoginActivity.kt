package br.com.agilles.iddog.ui.activity

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.ViewGroup
import android.widget.Toast
import br.com.agilles.iddog.R
import br.com.agilles.iddog.model.Dog
import br.com.agilles.iddog.model.User
import br.com.agilles.iddog.retrofit.client.UserWebClient
import br.com.agilles.iddog.ui.dialog.DialogSignUp
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private var dog: Dog = Dog("", listOf())
    private var user = User("", "")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        configuraClickSignup()
        configuraClickEntrar()

    }

    private fun configuraClickEntrar() {

        login_botao_entrar.setOnClickListener {
            UserWebClient().enter(user.token, "pug", {
                dog = it
            }, {
                Toast.makeText(this, "Falha ao buscar as fotos", Toast.LENGTH_LONG).show()

            })
        }

    }

    fun configuraClickSignup() {
        sign_up.setOnClickListener {
            DialogSignUp(this, window.decorView as ViewGroup).show {
                user = it
                login_email_edit_text.setText(it.email)
            }
        }
    }
}
