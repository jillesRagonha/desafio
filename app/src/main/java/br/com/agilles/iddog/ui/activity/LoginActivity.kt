package br.com.agilles.iddog.ui.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import br.com.agilles.iddog.R
import br.com.agilles.iddog.model.Dog
import br.com.agilles.iddog.model.User
import br.com.agilles.iddog.retrofit.client.UserWebClient
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private var dog: Dog = Dog("", listOf())
    private var user = User("", "")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        configClickEntrar()

    }

    private fun configClickEntrar() {
        login_botao_entrar.setOnClickListener {
            if (validaEmail()){

                showProgressBar()

                val email = login_email_edit_text.text.toString()
                user = User(email, "")
                UserWebClient().addEmail(user, {
                    user = User(it.user.email, it.user.token)
                    Toast.makeText(this, "Perfeito", Toast.LENGTH_SHORT).show()
                    Toast.makeText(this, "Perfeito ${user.token}", Toast.LENGTH_SHORT).show()
                    hideProgressBar()
                }, {
                    Toast.makeText(this, "Falha ao gravar o email", Toast.LENGTH_SHORT).show()

                })
                goToNextActivity()


            }


        }

    }

    private fun goToNextActivity() {


    }

    private fun hideProgressBar() {
        login_progress_bar.visibility = View.GONE
        login_texto_progress.visibility = View.GONE
    }

    fun showProgressBar() {
        login_progress_bar.visibility = View.VISIBLE
        login_texto_progress.visibility = View.VISIBLE
    }

    fun validaEmail(): Boolean {
        if (login_email_edit_text.text.isEmpty()) {
            login_layout_email.isErrorEnabled = true
            login_layout_email.error = "Preencha o campo Email"
            return false
        }
        return true

    }
}
