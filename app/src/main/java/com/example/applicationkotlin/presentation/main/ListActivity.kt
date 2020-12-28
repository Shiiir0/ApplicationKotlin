package com.example.applicationkotlin.presentation.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.applicationkotlin.R
import com.example.applicationkotlin.domain.entity.Character

class ListActivity : AppCompatActivity() {
    lateinit var characters: ArrayList<Character>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val rvCharacters = findViewById<View>(R.id.rvCharacters) as RecyclerView
        characters = Character.createCharactersList(20)
        val adapter = CharacterAdapter(characters)
        rvCharacters.adapter = adapter
        rvCharacters.layoutManager = LinearLayoutManager(this)

    }
}