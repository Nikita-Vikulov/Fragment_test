package com.example.fragment_test.view

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.fragment2.R
import com.example.fragment2.databinding.DescriptionFragmentBinding
import com.example.fragment_test.BaseFragment
import com.example.fragment_test.DataModel

class DescriptionFragment:BaseFragment<DescriptionFragmentBinding>() {

    private val dataModel: DataModel by activityViewModels()

    override fun getViewBinding(container: ViewGroup?): DescriptionFragmentBinding =
        DescriptionFragmentBinding.inflate(layoutInflater, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonSave.setOnClickListener {
            dataModel.messageDesc.value = binding.etDescription.text.toString()
            findNavController().navigate(R.id.action_descriptionFragment_to_profileFragment)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }
}