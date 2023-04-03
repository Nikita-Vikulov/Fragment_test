package com.example.fragment_test

import androidx.fragment.app.Fragment
import com.example.fragment_test.view.*

object Screens {
    const val LOGIN = "Login"
    const val PROFILE = "Profile"
    const val DESCRIPTION = "Description"
    const val CALENDAR = "Calendar"
    const val SETTINGS = "Settings"

    fun Login(): Fragment = LoginFragment()
    fun Profile(): Fragment = ProfileFragment()
    fun Description(): Fragment = SettingsFragment()
    fun Calendar(): Fragment = DescriptionFragment()
    fun Settings(): Fragment = CalendarFragment()
}