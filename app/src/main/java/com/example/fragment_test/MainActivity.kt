package com.example.fragment_test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.fragment2.R
import com.example.fragment2.databinding.ActivityMainBinding
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var dataModel: DataModel

    private lateinit var navigator: Navigator
    private lateinit var navigatorHolder: NavigatorHolder
    private lateinit var router: Router

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dataModel = ViewModelProvider(this)[DataModel::class.java]

        navigatorHolder = App.INSTANCE.getNavigatorHolder()
        router = App.INSTANCE.getRouter()

        val navigator = SupportAppNavigator(this, R.id.fl_fragment)
        navigatorHolder.setNavigator(navigator)
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}

