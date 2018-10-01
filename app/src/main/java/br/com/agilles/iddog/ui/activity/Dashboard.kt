package br.com.agilles.iddog.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.agilles.iddog.R
import br.com.agilles.iddog.model.Dog
import br.com.agilles.iddog.ui.adapter.DogsAdapter
import kotlinx.android.synthetic.main.activity_dashboard.*

class Dashboard : AppCompatActivity() {

    var listaCategorias = mutableListOf<Dog>()

    var token: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        token = intent.getStringExtra("TOKEN")


        listaCategorias = criaCategorias() as MutableList<Dog>

        configuraView()
    }

    private fun configuraView() {

        val recyclerView = recyclerView
        with(recyclerView) {
            context?.let {
                adapter = DogsAdapter(listaCategorias, it, token)

            }
        }

    }

    private fun criaCategorias(): List<Dog> {

        return listOf(
                Dog(category = "Hound", imagesUrl = emptyList()),
                Dog(category = "Husky", imagesUrl = emptyList()),
                Dog(category = "Pug", imagesUrl = emptyList()),
                Dog(category = "Labrador", imagesUrl = emptyList())
        )


    }
}
