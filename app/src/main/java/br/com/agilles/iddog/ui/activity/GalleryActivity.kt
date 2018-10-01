package br.com.agilles.iddog.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import br.com.agilles.iddog.R
import br.com.agilles.iddog.ui.adapter.GalleryAdapter
import kotlinx.android.synthetic.main.activity_gallery.*

class GalleryActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)
        val bundle: Bundle? = intent.extras
        val listImages:ArrayList<String> = intent.getStringArrayListExtra("DOGS")
        configItens(listImages)
    }

    private fun configItens(imagens: ArrayList<String>) {
        val recyclerView: RecyclerView = recyclerViewGallery
        with(recyclerView) {
            context?.let {

                layoutManager = GridLayoutManager(this@GalleryActivity, 4)
                adapter = GalleryAdapter(imagens, this@GalleryActivity)

            }
        }
    }
}
