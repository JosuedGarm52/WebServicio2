package com.example.webservicio2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.webservicio2.R
import com.example.webservicio2.Singleton.Singleton
import com.example.webservicio2.models.RickAndMortyApi.Character
class RickAndMortyAdapter : ListAdapter<Character, RickAndMortyAdapter.ViewHolder>(RickAndMortyComparator()) {

    class ViewHolder(rickandmorty_item: View) : RecyclerView.ViewHolder(rickandmorty_item) {
        val tvNombre = rickandmorty_item.findViewById<TextView>(R.id.tvNombre)
        val tvStatus = rickandmorty_item.findViewById<TextView>(R.id.tvStatus)
        val tvSpecie = rickandmorty_item.findViewById<TextView>(R.id.tvSpecie)
        val imgvFoto = rickandmorty_item.findViewById<ImageView>(R.id.imgvFoto)

        fun bind(personaje: Character) {
            tvNombre.text = "Name: " + personaje.name
            tvStatus.text = "Status: " + personaje.status
            tvSpecie.text = "Specie: " + personaje.species
            Glide.with(itemView)
                .load(personaje.image)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(imgvFoto)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rickandmorty_item = LayoutInflater.from(parent.context).inflate(R.layout.rickandmortyitem, parent, false)
        return ViewHolder(rickandmorty_item)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class RickAndMortyComparator: DiffUtil.ItemCallback<Character>() {

        override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
            return oldItem == newItem
        }
        override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
            return oldItem.id == newItem.id
        }
    }
}
