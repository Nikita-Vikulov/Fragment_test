package com.example.fragment_test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import com.example.fragment2.R
import com.example.fragment2.databinding.ActivityMainBinding
import com.example.fragment_test.view.*

class MainActivity : AppCompatActivity(), INavigation {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var dataModel: DataModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dataModel = ViewModelProvider(this)[DataModel::class.java]
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun openLoginFragment() {
        setupFragment(LoginFragment(), LOGIN)
    }

    override fun openProfileFragment() {
        setupFragment(ProfileFragment(), PROFILE)
    }

    override fun openDescriptionFragment() {
        setupFragment(DescriptionFragment(), DESCRIPTION)
    }

    override fun openCalendarFragment() {
        setupFragment(CalendarFragment(), CALENDAR)
    }

    override fun openSettingsFragment() {
        setupFragment(SettingsFragment(), SETTINGS)
    }

    override fun clearBackStack(name: String) {
        supportFragmentManager.popBackStack(name, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }

    private fun setupFragment(fragment: Fragment, name: String?) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_fragment, fragment)
            addToBackStack(name)
            commit()
        }
    }

}

