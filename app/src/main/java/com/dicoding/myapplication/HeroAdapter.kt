package com.dicoding.myapplication

import android.content.Context
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class Hero(
    var name: String,
    var description: String,
    var photo: Int,
    var additionalInfo: String
) : Parcelable {
    companion object {
        @JvmField
        val HEROES = listOf(
            Hero("Superman", "The Man of Steel", R.drawable.superman, "Flight, Super Strength"),
            Hero("Batman", "The Dark Knight", R.drawable.batman, "Master Detective, Martial Artist"),
            Hero("Wonder Woman", "The Amazonian Princess", R.drawable.wonder_woman, "Lasso of Truth, Superhuman Agility"),
            Hero("Spider-Man", "The Friendly Neighborhood Spider-Man", R.drawable.spiderman, "Wall-Crawling, Spider-Sense"),
            Hero("Iron Man", "The Armored Avenger", R.drawable.ironman, "Powered Armor Suit"),
            Hero("Captain America", "The First Avenger", R.drawable.captain_america, "Vibranium Shield, Super Soldier Serum"),
            Hero("Black Widow", "The Spy", R.drawable.black_widow, "Master Spy, Martial Artist"),
            Hero("Thor", "The God of Thunder", R.drawable.thor, "Mjolnir, Godly Powers"),
            Hero("Hulk", "The Green Goliath", R.drawable.hulk, "Superhuman Strength, Invulnerability"),
            Hero("Flash", "The Scarlet Speedster", R.drawable.flash, "Super Speed, Time Travel")
        )
    }
}

class HeroAdapter(private val context: Context, private val heroes: List<Hero>, private val onItemClick: (Hero) -> Unit) :
    RecyclerView.Adapter<HeroAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_hero, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = heroes[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description

        holder.itemView.setOnClickListener {
            onItemClick(heroes[position])
        }
    }

    override fun getItemCount(): Int {
        return heroes.size
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }
}