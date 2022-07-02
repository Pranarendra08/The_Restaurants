package com.example.therestaurants

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.therestaurants.api.ApiConfig
import com.example.therestaurants.api.ApiService
import com.example.therestaurants.api.model.ResponseDetailRestaurant
import com.example.therestaurants.api.model.ResponsePhotoRestaurant
import com.example.therestaurants.databinding.ActivityDetailBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var client: ApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        client = ApiConfig.getApiService()

        if (intent.hasExtra(EXTRA_ID)) {
            val id = intent.getStringExtra(EXTRA_ID)
            if (!id.isNullOrEmpty()) {
                initViews(id)
            }
        }
    }

    private fun initViews(id: String) {
        client.getDetailRestaurant(id).enqueue(object : Callback<ResponseDetailRestaurant> {
            override fun onResponse(
                call: Call<ResponseDetailRestaurant>,
                response: Response<ResponseDetailRestaurant>
            ) {
                if (response.isSuccessful) {
                    with(binding) {
                        val data = response.body()?.restaurant

                        data?.apply {
                            Glide.with(this@DetailActivity)
                                .load(client.getPhotoRestaurant(data.pictureId.toString()))
                                .into(ivPhotoRestaurant)
                            tvNama.text = name
                            tvCity.text = city
                            tvDesc.text = description
                        }
                    }
                } else {
                    setToast()
                }
            }
            override fun onFailure(call: Call<ResponseDetailRestaurant>, t: Throwable) {
                setToast()
            }
        })
    }

    private fun setToast() {
        Toast.makeText(this, "Error has occurred!", Toast.LENGTH_LONG).show()
    }

    companion object {
        const val EXTRA_ID = "EXTRA_ID"
    }
}