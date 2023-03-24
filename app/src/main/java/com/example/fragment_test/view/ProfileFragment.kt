package com.example.fragment_test.view

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.fragment2.R
import com.example.fragment2.databinding.ProfileFragmentBinding
import com.example.fragment_test.BaseFragment
import com.example.fragment_test.DataModel

class ProfileFragment : BaseFragment<ProfileFragmentBinding>() {
    private val dataModel: DataModel by activityViewModels()

    override fun getViewBinding(container: ViewGroup?): ProfileFragmentBinding =
        ProfileFragmentBinding.inflate(layoutInflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        binding.buttonSettings.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_settingsFragment)
        }
        binding.buttonCalendar.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_calendarFragment)
        }
        binding.buttonDescription.setOnClickListener{
            findNavController().navigate(R.id.action_profileFragment_to_descriptionFragment)
        }
    }

    private fun init() {
        dataModel.messageAuth.observe(activity as LifecycleOwner) {
            val messageAuth = it
            binding.tvLogin.text = messageAuth?.get(0)
            binding.tvPassword.text = messageAuth?.get(1)
        }
        dataModel.messageSett.observe(activity as LifecycleOwner) {
            val messageSett = it
            binding.tvName.text = messageSett?.get(0)
            binding.tvSurname.text = messageSett?.get(1)
        }
        dataModel.messageDesc.observe(activity as LifecycleOwner){
            binding.tvDescription.text = it
        }
        dataModel.messageDate.observe(activity as LifecycleOwner){
            binding.tvDate.text = it
        }
        Glide.with(this)
            .load("https://mykaleidoscope.ru/x/uploads/posts/2022-09/1663200138_15-mykaleidoscope-ru-p-veselii-tyulen-pinterest-15.jpg")
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(binding.imageView)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }
}