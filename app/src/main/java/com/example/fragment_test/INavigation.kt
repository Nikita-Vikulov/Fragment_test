package com.example.fragment_test

interface INavigation{
    fun openLoginFragment()
    fun openProfileFragment()
    fun openSettingsFragment()
    fun clearBackStack()
}