package com.example.therestaurants.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.therestaurants.R
import com.example.therestaurants.databinding.FragmentFragment2Binding
import com.example.therestaurants.utils.User


class fragment2 : Fragment() {

    private var _binding: FragmentFragment2Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFragment2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        if (activity != null && context != null) {
            with(binding) {
                val user = User()
                Glide.with(this@fragment2)
                    .load(R.drawable.ic_photo_profile)
                    .apply(RequestOptions.circleCropTransform())
                    .into(ivPhotoProfile)
                tvNama.text = user.nama
                tvEmail.text = user.email
                tvTtl.text = user.ttl
            }
        }
    }
}