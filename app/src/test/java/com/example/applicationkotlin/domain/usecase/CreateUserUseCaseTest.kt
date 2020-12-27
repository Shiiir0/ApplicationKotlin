package com.example.applicationkotlin.domain.usecase

import com.example.applicationkotlin.data.repository.UserRepository
import com.example.applicationkotlin.domain.entity.User
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Test

class CreateUserUseCaseTest {

    private val userRepository : UserRepository = mockk()

    private val classUnderTest = GetUserUseCase(userRepository)

    @Test
    fun `invoke with invalid email`() {
        runBlocking{
            //GIVEN
            val email = ""
            coEvery { userRepository.getUser(email) } returns null

            //WHEN
            val result : User? = classUnderTest.invoke(email)

            //THEN
            coVerify(exactly = 1) { userRepository.getUser(email) }
            assertEquals(result, null)
        }
    }

    @Test
    fun `invoke with valid email`() {
        runBlocking{
            //GIVEN
            val email = "a@a.com"
            val expectedUser = User(email)
            coEvery { userRepository.getUser(email) } returns expectedUser

            //WHEN
            val result : User? = classUnderTest.invoke(email)

            //THEN
            coVerify(exactly = 1) { userRepository.getUser(email) }
            assertEquals(result, expectedUser)
        }
    }
}