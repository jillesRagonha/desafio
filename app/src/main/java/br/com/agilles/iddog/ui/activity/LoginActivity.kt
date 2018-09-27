package br.com.agilles.iddog.ui.activity

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.ViewGroup
import android.widget.Toast
import br.com.agilles.iddog.R
import br.com.agilles.iddog.ui.dialog.DialogSignUp
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        configuraClickSignup()

    }

    fun configuraClickSignup() {
        sign_up.setOnClickListener {
            DialogSignUp(this, window.decorView as ViewGroup).show {

            }
        }
    }
}
