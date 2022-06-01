package com.example.therestaurants

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.therestaurants.databinding.ActivityMainBinding

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

            val fragmentOne = fragment1()
            val fragmentTwo = fragment2()
            supportFragmentManager.beginTransaction().apply {
                replace(fcvFragment1.id, fragmentOne)
                addToBackStack(null)
                commit()
            }
        }
    }
}