package com.example.fragment_test.view

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.fragment2.databinding.LoginFragmentBinding
import com.example.fragment_test.BaseFragment
import com.example.fragment_test.DataModel
import com.example.fragment_test.LOGIN
import com.example.fragment_test.MyNavigator
import com.github.terrakok.cicerone.Navigator

class LoginFragment(private val myParam: String) : BaseFragment<LoginFragmentBinding>() {
    val fragment = LoginFragment("my_param_value")
    private val dataModel: DataModel by activityViewModels()

    private val navigator: Navigator by lazy {
        MyNavigator(this)
    }
    override fun getViewBinding(container: ViewGroup?): LoginFragmentBinding =
        LoginFragmentBinding.inflate(layoutInflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonRegistration.setOnClickListener {
            val login = binding.etLogin.text.toString()
            val password = binding.etPassword.text.toString()
            val message: ArrayList<String> = arrayListOf(login, password)
            dataModel.messageAuth.value = message
            listener.openProfileFragment()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is INavigation) {
            listener = context
        }
    }

    override fun onStop() {
        super.onStop()
        listener.clearBackStack(LOGIN)
    }
}