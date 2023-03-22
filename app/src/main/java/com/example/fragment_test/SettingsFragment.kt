package com.example.fragment_test

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.fragment2.databinding.SettingsFragmentBinding

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

    override fun onDestroy() {
        super.onDestroy()
        listener.clearBackStack()
    }

}