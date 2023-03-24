package com.example.fragment_test.view

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.fragment2.R
import com.example.fragment2.databinding.LoginFragmentBinding
import com.example.fragment_test.BaseFragment
import com.example.fragment_test.DataModel

class LoginFragment : BaseFragment<LoginFragmentBinding>() {

    private val dataModel: DataModel by activityViewModels()
    override fun getViewBinding(container: ViewGroup?): LoginFragmentBinding =
        LoginFragmentBinding.inflate(layoutInflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonRegistration.setOnClickListener {
            val login = binding.etLogin.text.toString()
            val password = binding.etPassword.text.toString()
            val message: ArrayList<String> = arrayListOf(login, password)
            dataModel.messageAuth.value = message
            findNavController().navigate(R.id.action_loginFragment_to_profileFragment)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }
}