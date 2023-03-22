package com.example.fragment_test

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import com.bumptech.glide.Glide
import com.example.fragment2.R
import com.example.fragment2.databinding.ProfileFragmentBinding

class ProfileFragment : Fragment() {
    private var _binding: ProfileFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var listener: INavigation

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ProfileFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        binding.buttonSettings.setOnClickListener {
            listener.openSettingsFragment()
        }
    }

    private fun init() {
        setFragmentResultListener("requestLogin") { key, bundle ->
            val userAuthorization = bundle.getStringArrayList("bundleLogin")
            binding.tvLogin.text = userAuthorization?.get(0)
            binding.tvPassword.text = userAuthorization?.get(1)
        }
        setFragmentResultListener("requestSettings") { key, bundle ->
            val userSettings = bundle.getStringArrayList("bundleSettings")
            binding.tvName.text = userSettings?.get(0)
            binding.tvSurname.text = userSettings?.get(1)
        }
        Glide.with(this)
            .load("https://mykaleidoscope.ru/x/uploads/posts/2022-09/1663200138_15-mykaleidoscope-ru-p-veselii-tyulen-pinterest-15.jpg")
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(binding.imageView)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is INavigation) {
            listener = context
        }
    }
}