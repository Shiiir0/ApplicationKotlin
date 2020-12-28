package com.example.applicationkotlin.presentation.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.applicationkotlin.R
import com.example.applicationkotlin.domain.entity.Character

class CharacterAdapter(private val mCharacters: List<Character>) : RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    inner class ViewHolder(listItemView: View) : RecyclerView.ViewHolder(listItemView) {

        val firstLine = itemView.findViewById<TextView>(R.id.firstLine)
        val image = itemView.findViewById<ImageView>(R.id.icon)
        val secondLine = itemView.findViewById<TextView>(R.id.secondLine)
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
        val character: Character = mCharacters.get(position)

        val firstLineTextView = viewHolder.firstLine
        firstLineTextView.text = character.surname
        val image = viewHolder.image
        val secondLineTextView = viewHolder.secondLine
        secondLineTextView.text =  character.test
    }

    override fun getItemCount(): Int {
        return mCharacters.size
    }
}