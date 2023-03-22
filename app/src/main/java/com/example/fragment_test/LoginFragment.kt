package com.example.fragment_test

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import com.example.fragment2.databinding.LoginFragmentBinding

class LoginFragment : BaseFragment<LoginFragmentBinding>() {

    private lateinit var listener: INavigation

    override fun getViewBinding(container: ViewGroup?): LoginFragmentBinding =
        LoginFragmentBinding.inflate(layoutInflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonRegistration.setOnClickListener {
            val login = binding.etLogin.text.toString()
            val password = binding.etPassword.text.toString()
            val userAuthorization: ArrayList<String> = arrayListOf(login, password)
            setFragmentResult("requestLogin", bundleOf("bundleLogin" to userAuthorization))
            listener.openProfileFragment()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is INavigation) {
            listener = context
        }
    }
}