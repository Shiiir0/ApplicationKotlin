package com.example.applicationkotlin.presentation.main

import com.example.applicationkotlin.domain.entity.User

sealed class RegisterStatus

data class RegisterSuccess(val user: User) : RegisterStatus()

object RegisterError : RegisterStatus()