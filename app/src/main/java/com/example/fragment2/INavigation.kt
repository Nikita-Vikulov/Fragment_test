package com.example.fragment2

interface INavigation{
    fun openLoginFragment()
    fun openProfileFragment()
    fun openSettingsFragment()
    fun clearBackStack()
}