package com.example.applicationkotlin.presentation.main;

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.applicationkotlin.R
import com.example.applicationkotlin.domain.entity.Character
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val character: Character? = intent.extras?.get("EXTRA_CHARACTER") as Character?

        val firstLine = findViewById<TextView>(R.id.textView)
        val secondLine = findViewById<TextView>(R.id.textView2)
        val thirdLine = findViewById<TextView>(R.id.textView3)
        val forthLine = findViewById<TextView>(R.id.textView4)
        val fifthLine = findViewById<TextView>(R.id.textView5)
        val sixthLine = findViewById<TextView>(R.id.textView6)
        val seventhLine = findViewById<TextView>(R.id.textView7)
        val eighthLine = findViewById<TextView>(R.id.textView8)
        val ninthLine = findViewById<TextView>(R.id.textView9)

        if (character != null) {

            Picasso.get().load(character.image).into(imageView)
            if(character.name != "") {
                firstLine.text = "Name : " + character.name
            }else firstLine.text = "Name : Unknown"

            if(character.ancestry != "") {
                secondLine.text = "Ancestry : " + character.ancestry
            }else secondLine.text = "Ancestry : Unknown"

            if(character.species != "") {
                thirdLine.text = "Specie : " + character.species
            }else thirdLine.text = "Specie : Unknown"

            if(character.gender != "") {
                forthLine.text = "Gender : " + character.gender
            }else forthLine.text = "Gender : Unknown"

            if(character.house != "") {
                fifthLine.text = "House : " + character.house
            }else fifthLine.text = "House : Unknown"

            if(character.dateOfBirth != "") {
                sixthLine.text = "Date Of birth : " + character.dateOfBirth
            }else sixthLine.text = "Date Of birth : Unknown"

            if(character.patronus != "") {
                seventhLine.text = "Patronus : " + character.patronus
            }else seventhLine.text = "Patronus : Unknown"

            if(character.actor != "") {
                eighthLine.text = "Actor : " + character.actor
            }else eighthLine.text = "Actor : Unknown"

            if(character.hairColour != "") {
                ninthLine.text = "Hair Colour : " + character.hairColour
            }else ninthLine.text = "Hair Colour : Unknown"
        }
    }


}