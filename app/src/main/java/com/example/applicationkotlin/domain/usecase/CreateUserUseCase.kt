package com.example.applicationkotlin.domain.usecase

import com.example.applicationkotlin.data.repository.UserRepository
import com.example.applicationkotlin.domain.entity.User

class CreateUserUseCase(private val userRepository: UserRepository) {
    suspend fun invoke(user: User) {
        userRepository.createUser(user)
    }
}