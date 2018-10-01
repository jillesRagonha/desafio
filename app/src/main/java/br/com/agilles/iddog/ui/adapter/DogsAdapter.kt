package br.com.agilles.iddog.ui.adapter

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import br.com.agilles.iddog.R
import br.com.agilles.iddog.model.Dog
import br.com.agilles.iddog.retrofit.client.DogWebClient
import br.com.agilles.iddog.ui.activity.Dashboard
import br.com.agilles.iddog.ui.activity.GalleryActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_dashboard_dog.view.*
import java.util.ArrayList

class DogsAdapter(private val dogs: List<Dog>,
                  private val context: Context,
                  private val token: String) : RecyclerView.Adapter<DogsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogsViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_dashboard_dog, parent, false)
        return DogsViewHolder(view)

    }


    override fun getItemCount(): Int {
        return dogs.size
    }


    override fun onBindViewHolder(holder: DogsViewHolder, position: Int) {
        val dog = dogs[position]
        holder.bindView(dog, context, token)
    }
}


class DogsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    fun bindView(dog: Dog, context: Context, token: String) {

        when (dog.category) {
            "Hound" -> Picasso.get()
                    .load(R.drawable.hound)
                    .into(itemView.imagem)
            "Husky" -> Picasso.get()
                    .load(R.drawable.husky)
                    .into(itemView.imagem)
            "Pug" -> Picasso.get()
                    .load(R.drawable.pug)
                    .into(itemView.imagem)
            "Labrador" -> Picasso.get()
                    .load(R.drawable.labrador)
                    .into(itemView.imagem)
        }
        itemView.titulo_dog.text = dog.category

        configClick(token, dog.category, context)

    }

    fun configClick(token: String, category: String, context: Context) {
        itemView.container.setOnClickListener {
            DogWebClient().listDogs(token, category.decapitalize(), { dog ->
                goToNextActivity(dog, context)
            }, {

            })
        }
    }

    fun goToNextActivity(dog: Dog, context: Context) {
        var intent = Intent(context, GalleryActivity::class.java)
        intent.putStringArrayListExtra("DOGS", dog.imagesUrl as ArrayList<String>)
        context.startActivity(intent)

    }


}