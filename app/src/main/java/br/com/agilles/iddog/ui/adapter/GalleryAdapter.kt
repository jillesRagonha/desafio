package br.com.agilles.iddog.ui.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import br.com.agilles.iddog.R
import br.com.agilles.iddog.model.Dog
import br.com.agilles.iddog.ui.activity.GalleryActivity
import br.com.agilles.iddog.ui.activity.ImageDetailActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_gallery.view.*

class GalleryAdapter(private val images: ArrayList<String>,
                     private val context: Context) : RecyclerView.Adapter<GalleryViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_gallery, parent, false)
        return GalleryViewHolder(view)

    }

    override fun getItemCount(): Int {
        return images.size
    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        val image = images[position]
        holder.bindView(image, context)
    }
}


class GalleryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bindView(image: String, context: Context) {
        Picasso.get()
                .load(image)
                .into(itemView.imagem_dog)
        itemView.setOnClickListener {
            goToDetailImage(image,context)
        }

    }

    private fun goToDetailImage(image:String, context: Context) {
        var intent = Intent(context, ImageDetailActivity::class.java)
        intent.putExtra("DOG", image)
        context.startActivity(intent)

    }


}



