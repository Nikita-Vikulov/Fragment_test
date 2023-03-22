package com.example.fragment_test

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


open class DataModel : ViewModel() {
    val messageAuth: MutableLiveData<ArrayList<String>> by lazy {
        MutableLiveData<ArrayList<String>>()
    }
    val messageSett: MutableLiveData<ArrayList<String>> by lazy {
        MutableLiveData<ArrayList<String>>()
    }
}