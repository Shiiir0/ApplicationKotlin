package com.example.applicationkotlin.data.repository

import com.example.applicationkotlin.data.local.DatabaseDao
import com.example.applicationkotlin.data.local.models.UserLocal
import com.example.applicationkotlin.data.local.models.toData
import com.example.applicationkotlin.data.local.models.toEntity
import com.example.applicationkotlin.domain.entity.User

class UserRepository(private val databaseDao: DatabaseDao) {
    suspend fun createUser(user: User) {
        //Appel API pour mettre a jour la base de donnée
        databaseDao.insert(user.toData())
    }

    fun getUser(email: String) : User {
        val userLocal : UserLocal = databaseDao.findByName(email)
        return userLocal.toEntity()
    }
}