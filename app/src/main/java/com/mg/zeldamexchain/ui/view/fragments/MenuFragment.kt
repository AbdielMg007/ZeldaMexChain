package com.mg.zeldamexchain.ui.view.fragments

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.mg.zeldamexchain.R
import com.mg.zeldamexchain.databinding.FragmentMenuBinding
import com.mg.zeldamexchain.ui.adapters.AdapterPublication
import com.mg.zeldamexchain.ui.viewmodels.PublicationsViewModel

class MenuFragment : Fragment(R.layout.fragment_menu) {

    private lateinit var binding: FragmentMenuBinding
    private val publicationViewModel: PublicationsViewModel by viewModels()
    private lateinit var adapter: AdapterPublication

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMenuBinding.bind(view)
        setup()
    }

    private fun setup() {
        adapter = AdapterPublication(arrayListOf())

        binding.recyclerHome.layoutManager = LinearLayoutManager(context)
        binding.recyclerHome.adapter = adapter

        publicationViewModel.list.observe(viewLifecycleOwner) { newPublications ->
            adapter.updateItems(newPublications)
        }
    }

}