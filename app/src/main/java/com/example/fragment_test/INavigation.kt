package com.example.fragment_test

import androidx.fragment.app.Fragment

interface INavigation {
    fun openLoginFragment()
    fun openProfileFragment()
    fun openSettingsFragment()
    fun openDescriptionFragment()
    fun openCalendarFragment()
    fun clearBackStack()

}