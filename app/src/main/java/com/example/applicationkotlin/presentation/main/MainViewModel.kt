package com.example.applicationkotlin.presentation.main

import android.view.KeyEvent
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.applicationkotlin.domain.entity.User
import com.example.applicationkotlin.domain.usecase.CreateUserUseCase
import com.example.applicationkotlin.domain.usecase.GetAccountUseCase
import com.example.applicationkotlin.domain.usecase.GetUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(
        private val createUserUseCase: CreateUserUseCase,
        private val getUserUseCase: GetUserUseCase,
        private val getAccountUseCase : GetAccountUseCase
) : ViewModel() {

    val loginLiveData: MutableLiveData<LoginStatus> = MutableLiveData()
    val registerLiveData: MutableLiveData<RegisterStatus> = MutableLiveData()

    fun onClickedLogin(emailUser: String, passwordUser: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val user : User? = getAccountUseCase.invoke(emailUser, passwordUser)
            val loginStatus : LoginStatus = if(user != null) {
                LoginSuccess(user.email, user.password)
            }else {
                LoginError
            }
            withContext(Dispatchers.Main) {
                loginLiveData.value = loginStatus
            }
        }
    }

    fun onClickedRegister(emailUser: String, passwordUser: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val user = User(emailUser, passwordUser)
            val userExisting: User? = getUserUseCase.invoke(emailUser)
            val registerStatus : RegisterStatus = if(emailUser != "" && passwordUser != "" && emailUser != userExisting?.email) {
                createUserUseCase.invoke(user)
                RegisterSuccess(user)
            }else {
                RegisterError
            }
            withContext(Dispatchers.Main) {
                registerLiveData.value = registerStatus
            }
        }
    }


}