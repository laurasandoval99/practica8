package com.hsofiamunoz.practica8.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hsofiamunoz.practica8.R
import com.hsofiamunoz.practica8.databinding.CatListItemBinding
import com.hsofiamunoz.practica8.model.CatItem

class catAdapter (
    private val onITemClicked:(CatItem)->Unit,
): RecyclerView.Adapter<catAdapter.ViewHolder>(){

    private var listCat:MutableList<CatItem> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): catAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cat_list_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: catAdapter.ViewHolder, position: Int) {
        holder.bind(listCat[position])
        holder.itemView.setOnClickListener { onITemClicked(listCat[position]) }
    }

    override fun getItemCount(): Int = listCat.size


    fun appendItems(newItems: MutableList<CatItem>){
        listCat.clear()
        listCat.addAll(newItems)
        notifyDataSetChanged()
    }

    class ViewHolder(view:View): RecyclerView.ViewHolder(view){
        private val binding = CatListItemBinding.bind(view)
        private val context: Context = binding.root.context

        fun bind(cat : CatItem){
            with(binding){
                nameCatTextView.text = cat.name
                //releaseTextView.text =context.getString(R.string.release_info, movie.releaseDate)
                //voteTextView.text = context.getString(R.string.vote_avg_info, movie.voteAverage.toString())

                //if(movie.posterPath!=null)
                  //  Picasso.get().load("https://image.tmdb.org/t/p/w500" + movie.posterPath).into(pictureImageView)
            }

        }

    }

}
