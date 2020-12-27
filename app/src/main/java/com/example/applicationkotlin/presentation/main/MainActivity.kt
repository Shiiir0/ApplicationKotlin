package com.example.applicationkotlin.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.applicationkotlin.R
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

import kotlin.reflect.KProperty


class MainActivity : AppCompatActivity() {

    val mainViewModel: MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_button.setOnClickListener{
            mainViewModel.onClickedButton("")
        }

        mainViewModel.text.observe(this, Observer {
            main_text.text = it.toString()
        })
    }
}
