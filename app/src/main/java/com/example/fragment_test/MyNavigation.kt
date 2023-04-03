package com.example.fragment_test

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.navigation.Navigator
import com.example.fragment2.R
import com.github.terrakok.cicerone.BackTo
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.Forward
import com.github.terrakok.cicerone.Replace


class MyNavigator(private val activity: AppCompatActivity) : Navigator {

    override fun applyCommands(commands: Array<out Command>) {
        commands.forEach { applyCommand(it) }
    }

    private fun applyCommand(command: Command) {
        when (command) {
            is Forward -> activity.supportFragmentManager.beginTransaction()
                .replace(R.id.fl_fragment, command.screen.fragment)
                .addToBackStack(null)
                .commit()
            is Replace -> activity.supportFragmentManager.beginTransaction()
                .replace(R.id.fl_fragment, command.screen.fragment)
                .commit()
            is BackTo -> activity.supportFragmentManager.popBackStackImmediate(
                command.screenKey,
                FragmentManager.POP_BACK_STACK_INCLUSIVE
            )
        }
    }
}