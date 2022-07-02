package com.example.therestaurants

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.therestaurants.api.ApiConfig
import com.example.therestaurants.api.model.ResponseListRestaurant
import com.example.therestaurants.api.model.RestaurantItem
import com.example.therestaurants.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_TheRestaurants)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()

        supportActionBar?.hide()
    }

    private fun initViews() {
        with(binding) {
            val navHostfragment = supportFragmentManager
                .findFragmentById(fcvFragment1.id) as NavHostFragment
            val navController = navHostfragment.navController

            btmNav.setupWithNavController(navController)
        }
    }

}