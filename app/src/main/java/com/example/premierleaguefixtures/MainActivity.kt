package com.example.premierleaguefixtures

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.premierleaguefixtures.databinding.ActivityMainBinding
import com.example.premierleaguefixtures.utilities.APP_ACTIVITY

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        APP_ACTIVITY = this
        navController = Navigation.findNavController(this, R.id.nav_host_fragment_container)
    }
}