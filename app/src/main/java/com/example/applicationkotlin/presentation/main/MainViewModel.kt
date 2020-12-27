package com.example.applicationkotlin.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.applicationkotlin.domain.entity.User
import com.example.applicationkotlin.domain.usecase.CreateUserUseCase
import com.example.applicationkotlin.domain.usecase.GetUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel(
        private val createUserUseCase: CreateUserUseCase,
        private val getUserUseCase: GetUserUseCase
) : ViewModel() {

    fun onClickedButton(emailUser: String) {
        viewModelScope.launch(Dispatchers.IO) {
            createUserUseCase.invoke(User("test"))
            delay(1000)
            val user = getUserUseCase.invoke("test")
            val debug = "debug"
        }

        text.value =  (text.value?: 0) + 1
    }

    val text: MutableLiveData<Int> = MutableLiveData()

    init {
        text.value = 0
    }
}