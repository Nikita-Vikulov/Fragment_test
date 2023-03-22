package com.example.fragment_test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.fragment2.R
import com.example.fragment2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), INavigation {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setupFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_fragment, fragment)
            addToBackStack(null)
            commit()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun openLoginFragment() {
        setupFragment(LoginFragment())
    }

    override fun openProfileFragment() {
        setupFragment(ProfileFragment())
    }

    override fun openSettingsFragment() {
        setupFragment(SettingsFragment())
    }

    override fun clearBackStack(){
        supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }
}

