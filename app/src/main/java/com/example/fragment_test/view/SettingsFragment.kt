package com.example.fragment_test.view

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.fragment2.R
import com.example.fragment2.databinding.SettingsFragmentBinding
import com.example.fragment_test.BaseFragment
import com.example.fragment_test.DataModel

class SettingsFragment : BaseFragment<SettingsFragmentBinding>() {

    private val dataModel: DataModel by activityViewModels()
    override fun getViewBinding(container: ViewGroup?): SettingsFragmentBinding =
        SettingsFragmentBinding.inflate(layoutInflater, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonSave.setOnClickListener {
            val name = binding.etName.text.toString()
            val surname = binding.etSurname.text.toString()
            val message: ArrayList<String> = arrayListOf(name, surname)
            dataModel.messageSett.value = message
            findNavController().navigate(R.id.action_settingsFragment_to_profileFragment)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onDestroy() {
        super.onDestroy()
       // listener.clearBackStack()
    }

}