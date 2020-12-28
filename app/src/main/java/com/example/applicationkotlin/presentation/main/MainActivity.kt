package com.example.applicationkotlin.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.applicationkotlin.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject


class MainActivity : AppCompatActivity() {

    val mainViewModel: MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.loginLiveData.observe(this, Observer {
            when(it) {
                is LoginSuccess ->{}
                LoginError -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Erreur")
                        .setMessage("compte inconnu")
                        .setPositiveButton("OK") {dialog, which ->
                            dialog.dismiss()
                        }
                        .show()
                }
            }
        })

        mainViewModel.registerLiveData.observe(this, Observer {
            when(it) {
                is RegisterSuccess -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Success")
                        .setMessage("Compte créé !")
                        .setPositiveButton("OK") {dialog, which ->
                            dialog.dismiss()
                        }
                        .show()
                }
                RegisterError -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Error")
                        .setMessage("Paramètre invalide ou compte déjà existant")
                        .setPositiveButton("OK") {dialog, which ->
                            dialog.dismiss()
                        }
                        .show()
                }
            }
        })

        login_button.setOnClickListener{
            mainViewModel.onClickedLogin(login_edit.text.toString().trim(), password_edit.text.toString().trim())
        }
        create_account_button.setOnClickListener{
            mainViewModel.onClickedRegister(login_edit.text.toString().trim(), password_edit.text.toString().trim())
        }

    }
}
