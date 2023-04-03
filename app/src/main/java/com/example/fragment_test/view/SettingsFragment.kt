package com.example.fragment_test.view

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.fragment2.databinding.SettingsFragmentBinding
import com.example.fragment_test.BaseFragment
import com.example.fragment_test.DataModel
import com.example.fragment_test.SETTINGS

class SettingsFragment : BaseFragment<SettingsFragmentBinding>() {

    private lateinit var listener: INavigation
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
        listener.clearBackStack(SETTINGS)
    }

}