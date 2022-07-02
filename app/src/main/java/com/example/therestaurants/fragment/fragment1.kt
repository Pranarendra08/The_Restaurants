package com.example.therestaurants.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.therestaurants.DetailActivity
import com.example.therestaurants.adapter.RvAdapter
import com.example.therestaurants.api.ApiConfig
import com.example.therestaurants.api.model.ResponseListRestaurant
import com.example.therestaurants.api.model.RestaurantItem
import com.example.therestaurants.databinding.FragmentFragment1Binding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class fragment1 : Fragment(), RvAdapter.OnItemClickListener {

    private var _binding: FragmentFragment1Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFragment1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        if (activity != null && context != null) {
            with(binding) {
                activity?.let { act ->
                    progressList.visibility = View.VISIBLE
                    val client = ApiConfig.getApiService()

                    client.getListRestaurant().enqueue(object : Callback<ResponseListRestaurant> {
                        override fun onResponse(
                            call: Call<ResponseListRestaurant>,
                            response: Response<ResponseListRestaurant>
                        ) {
                            progressList.visibility = View.GONE

                            if (response.isSuccessful) {
                                val restaurantList = response.body()?.restaurants ?: ArrayList()

                                rvListRestaurant.setHasFixedSize(true)
                                rvListRestaurant.layoutManager =
                                    LinearLayoutManager(requireActivity())

                                val adapter = RvAdapter(ArrayList(restaurantList))
                                adapter.listener = this@fragment1

                                rvListRestaurant.adapter = adapter
                            } else {
                                progressOn()
                            }
                        }

                        override fun onFailure(call: Call<ResponseListRestaurant>, t: Throwable) {
                            progressOn()
                        }
                    })
                }
            }
        }
    }

    private fun progressOn() {
        with(binding) {
            progressList.visibility = View.GONE
            Toast.makeText(requireActivity(), "Error has occurred!", Toast.LENGTH_LONG).show()
        }
    }

    override fun onItemClicked(item: RestaurantItem) {
        startActivity(
            Intent(requireActivity(), DetailActivity::class.java).apply {
                putExtra(DetailActivity.EXTRA_ID, item.id)
            }
        )
    }

}