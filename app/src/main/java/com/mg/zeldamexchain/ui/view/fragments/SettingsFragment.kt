package com.mg.zeldamexchain.ui.view.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.mg.zeldamexchain.R
import com.mg.zeldamexchain.databinding.FragmentSettingsBinding
import com.mg.zeldamexchain.ui.view.activities.LoginActivity

class SettingsFragment : Fragment(R.layout.fragment_settings) {

    private lateinit var binding: FragmentSettingsBinding
    private lateinit var auth: FirebaseAuth


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSettingsBinding.bind(view)
        setup()
    }

    private fun setup() {
        auth = Firebase.auth
        val user = Firebase.auth.currentUser
        user?.let {
            val email = it.email
            binding.tvNameUser.text = email
        }
        binding.logOut.setOnClickListener {
            Firebase.auth.signOut()
        }
    }

}