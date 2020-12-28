package com.example.applicationkotlin.domain.entity

class Character(
    val surname: String,
    val URL : String,
    val test : String
) {

    companion object {
        private var lastContactId = 0
        fun createCharactersList(numCharacters: Int): ArrayList<Character> {
            val contacts = ArrayList<Character>()
            for (i in 1..numCharacters) {
                contacts.add(Character("Person " + ++lastContactId,
                                        lastContactId.toString(),
                                        lastContactId.toString()
                ))
            }
            return contacts
        }
    }
}
