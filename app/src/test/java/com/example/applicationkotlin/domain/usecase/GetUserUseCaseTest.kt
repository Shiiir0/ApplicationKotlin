package com.example.applicationkotlin.domain.usecase

import com.example.applicationkotlin.data.repository.UserRepository
import com.example.applicationkotlin.domain.entity.User
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test

class GetUserUseCaseTest {

    private val userRepository : UserRepository = mockk()

    private val classUnderTest = CreateUserUseCase(userRepository)

    @Test
    fun invoke() {
        runBlocking{
            //GIVEN
            val user = User("")
            coEvery { userRepository.createUser(user) } returns Unit

            //WHEN
            classUnderTest.invoke(user)

            //THEN
            coVerify(exactly = 1) { userRepository.createUser(user) }
        }
    }
}