package com.example.applicationkotlin.domain.entity

import java.io.Serializable

data class Character(
    val name : String?=" ",
    val species :  String?=" ",
    val gender :  String?=" ",
    val house :  String?=" ",
    val dateOfBirth :  String?=" ",
    //val yearOfBirth : Int?=0,
    val ancestry :  String?=" ",
    val eyeColour :  String?=" ",
    val hairColour :  String?=" ",
    //val wand : Wand,
    val patronus :  String?=" ",
    //val hogwartsStudent : Boolean,
    //val hogwartsStaff : Boolean,
    val actor :  String?=" ",
    //val alive : Boolean,
    val image :  String?=" "

) : Serializable {
        /*data class Wand(
            val wood :  String?=" ",
            val core :  String?=" "
            //val length : Int?=0
        )*/
    }

    /*companion object {
        private var lastContactId = 0
        fun createCharactersList(numCharacters: Int): ArrayList<Character> {
            val contacts = ArrayList<Character>()
            for (i in 1..numCharacters) {
                contacts.add(Character("Person " + ++lastContactId,
                                        lastContactId.toString(),
                                        lastContactId.toString(),
                                        lastContactId.toString(),
                                        lastContactId.toString(),
                                        1900,
                                        lastContactId.toString(),
                                        lastContactId.toString(),
                                        lastContactId.toString(),
                                        Wand("","",2),
                                        lastContactId.toString(),
                                        true,
                                        true,
                                        lastContactId.toString(),
                                        true,
                                        lastContactId.toString()
                ))
            }
            return contacts
        }
    }*/

