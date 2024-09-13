package com.mg.zeldamexchain.ui.helpers

import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.mg.zeldamexchain.R

object FragmentBack {
    fun backPress(fragment: Fragment) {
        fragment.requireActivity().onBackPressedDispatcher.addCallback(
            fragment.viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    fragment.findNavController().navigate(R.id.action_global_entryFragment)
                }
            })
    }
}