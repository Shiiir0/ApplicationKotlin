package com.example.applicationkotlin.injection

import com.example.applicationkotlin.MainViewModel
import org.koin.dsl.module

val presentationModule = module{
    factory { MainViewModel() }
}