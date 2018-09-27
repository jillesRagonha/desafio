package br.com.agilles.iddog.ui.dialog

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import br.com.agilles.iddog.R
import br.com.agilles.iddog.model.User
import br.com.agilles.iddog.retrofit.client.UserWebClient
import kotlinx.android.synthetic.main.form_user.view.*

class DialogSignUp(private val context: Context,
                   private val viewGroup: ViewGroup) {

    fun show(created: (user: User) -> Unit) {
        val createdView = LayoutInflater.from(context)
                .inflate(R.layout.form_user, viewGroup, false)
        AlertDialog.Builder(context)
                .setTitle("Novo Usuário")
                .setView(createdView)
                .setPositiveButton("Gravar") { _, _ ->
                    val email = createdView.form_user_email.text.toString()
                    val novoUsuario = User(email)

                    UserWebClient().addEmail(novoUsuario, {
                        created(it)
                    }, {
                        Toast.makeText(context, "Falha ao gravar o email", Toast.LENGTH_SHORT).show()
                    })
                }
                .show()
    }

}

