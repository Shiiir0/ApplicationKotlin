package com.example.applicationkotlin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    fun onClickedButton() {
        text.value =  (text.value?: 0) + 1
    }

    val text: MutableLiveData<Int> = MutableLiveData()

    init {
        text.value = 0
    }
}