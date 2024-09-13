package com.mg.zeldamexchain.ui.view.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.mg.zeldamexchain.R
import com.mg.zeldamexchain.databinding.FragmentIndexBinding
import com.mg.zeldamexchain.ui.view.activities.MenuActivity

class IndexFragment : Fragment(R.layout.fragment_index) {

    private lateinit var binding: FragmentIndexBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentIndexBinding.bind(view)
        binding.entryAccount.setOnClickListener {
            findNavController().navigate(R.id.action_indexFragment_to_entryFragment)
        }
        binding.entryWithoutAccount.setOnClickListener {
            val nextScreen = Intent(context, MenuActivity::class.java)
            startActivity(nextScreen)
        }
    }
}