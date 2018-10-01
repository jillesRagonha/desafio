package br.com.agilles.iddog.ui.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
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
            val email = login_email_edit_text.text.toString()

            if (validaEmail(email)){

                showProgressBar()

                user = User(email, "")
                UserWebClient().addEmail(user, {
                    user = User(it.user.email, it.user.token)
                    hideProgressBar()
                    goToNextActivity(user.token)

                }, {
                    Toast.makeText(this, "Falha ao gravar o email", Toast.LENGTH_SHORT).show()

                })


            }


        }

    }

    private fun goToNextActivity(token:String) {
        intent = Intent(this, Dashboard::class.java)
        intent.putExtra("TOKEN", token )
        startActivity(intent)


    }

    private fun hideProgressBar() {
        login_progress_bar.visibility = View.GONE
        login_texto_progress.visibility = View.GONE
    }

    fun showProgressBar() {
        login_progress_bar.visibility = View.VISIBLE
        login_texto_progress.visibility = View.VISIBLE
    }

    fun validaEmail(email:String): Boolean {
        if ( !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            return true
        }
        login_layout_email.isErrorEnabled = true
        login_layout_email.error = "Ops, Algo deu errado, verifique o email"

        return false




    }
}
