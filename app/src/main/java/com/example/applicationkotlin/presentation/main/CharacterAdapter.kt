package com.example.applicationkotlin.presentation.main

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.applicationkotlin.R
import com.example.applicationkotlin.domain.entity.Character
import com.squareup.picasso.Picasso

class CharacterAdapter(private val mCharacters: List<Character>, private val listener: OnItemClickListener): RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    inner class ViewHolder(listItemView: View) : RecyclerView.ViewHolder(listItemView), View.OnClickListener  {

        val firstLine = itemView.findViewById<TextView>(R.id.firstLine)
        val image = itemView.findViewById<ImageView>(R.id.icon)
        val secondLine = itemView.findViewById<TextView>(R.id.secondLine)

        init {
            itemView.setOnClickListener(this)
        }
        fun bind(character: Character) {

            firstLine.text = character.name
            secondLine.text = character.ancestry
            Picasso.get().load(character.image).into(image)
        }

        override fun onClick(v: View?) {
            val position: Int = adapterPosition
            if(position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position, mCharacters)
            }
        }


    }

    interface OnItemClickListener {

        fun onItemClick(position: Int, mCharacters: List<Character>)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.item_character, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(viewHolder: CharacterAdapter.ViewHolder, position: Int) {

        Log.d("Response", "List Count :${mCharacters.size} ")


        return viewHolder.bind(mCharacters[position])

    }

    override fun getItemCount(): Int {
        return mCharacters.size
    }
}