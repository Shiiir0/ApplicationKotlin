package com.example.applicationkotlin.injection

import android.content.Context
import androidx.room.Room
import com.example.applicationkotlin.data.local.AppDatabase
import com.example.applicationkotlin.data.local.DatabaseDao
import com.example.applicationkotlin.data.repository.UserRepository
import com.example.applicationkotlin.domain.usecase.CreateUserUseCase
import com.example.applicationkotlin.domain.usecase.GetAccountUseCase
import com.example.applicationkotlin.domain.usecase.GetUserUseCase
import com.example.applicationkotlin.presentation.main.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

val presentationModule = module{
    factory { MainViewModel(get(), get(), get()) }
}

val domainModule : Module = module {
    factory { CreateUserUseCase(get()) }
    factory { GetUserUseCase(get()) }
    factory { GetAccountUseCase(get()) }
}

val dataModule : Module = module {
    single { UserRepository(get()) }
    single { createDatabase(androidContext()) }
}

fun createDatabase(context: Context): DatabaseDao {
    val appDatabase: AppDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "database-name"
    ).build()
    return appDatabase.databaseDao()
}

