package com.example.fragment_test

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import com.example.fragment2.databinding.SettingsFragmentBinding

class SettingsFragment : BaseFragment<SettingsFragmentBinding>() {

    private lateinit var listener: INavigation

    override fun getViewBinding(container: ViewGroup?): SettingsFragmentBinding =
        SettingsFragmentBinding.inflate(layoutInflater, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonSave.setOnClickListener {
            val name = binding.etName.text.toString()
            val surname = binding.etSurname.text.toString()
            val userSettings: ArrayList<String> = arrayListOf(name, surname)
            setFragmentResult("requestSettings", bundleOf("bundleSettings" to userSettings))
            listener.openProfileFragment()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is INavigation) {
            listener = context
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        listener.clearBackStack()
    }

}