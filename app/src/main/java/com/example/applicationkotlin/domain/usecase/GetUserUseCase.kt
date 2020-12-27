package com.example.applicationkotlin.domain.usecase

import com.example.applicationkotlin.data.repository.UserRepository
import com.example.applicationkotlin.domain.entity.User

class GetUserUseCase(private val userRepository: UserRepository) {
    suspend fun invoke(email: String) {
        userRepository.getUser(email)
    }
}