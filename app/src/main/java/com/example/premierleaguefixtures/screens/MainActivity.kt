package com.example.premierleaguefixtures.screens

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.premierleaguefixtures.R
import com.example.premierleaguefixtures.utilities.APP_ACTIVITY

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        APP_ACTIVITY = this
        navController = Navigation.findNavController(this, R.id.nav_host_fragment_container)
    }
}