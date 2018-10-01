package br.com.agilles.iddog.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.agilles.iddog.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_image_detail.*

class ImageDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_detail)
        val imagem = intent.getStringExtra("DOG")
        Picasso.get()
                .load(imagem)
                .into(image_detail)
    }
}
