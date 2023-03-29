package com.example.fragment_test.view

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.fragment2.databinding.CalendarFragmentBinding
import com.example.fragment_test.*
import java.text.SimpleDateFormat

class CalendarFragment:BaseFragment<CalendarFragmentBinding>() {

    private lateinit var listener: INavigation
    private val dataModel: DataModel by activityViewModels()

    override fun getViewBinding(container: ViewGroup?): CalendarFragmentBinding =
        CalendarFragmentBinding.inflate(layoutInflater, container, false)


    @SuppressLint("SimpleDateFormat")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonSave.setOnClickListener {
            dataModel.messageDate.value = SimpleDateFormat("dd/MM/yyyy").format(binding.calendarView.date)
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
        listener.clearBackStack(CALENDAR)
    }
}