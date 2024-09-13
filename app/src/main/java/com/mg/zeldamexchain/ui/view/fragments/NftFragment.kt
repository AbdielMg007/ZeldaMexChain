package com.mg.zeldamexchain.ui.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.mg.zeldamexchain.R
import com.mg.zeldamexchain.databinding.FragmentNftBinding
import com.mg.zeldamexchain.ui.viewmodels.NftViewModel
import com.squareup.picasso.Picasso

class NftFragment : Fragment(R.layout.fragment_nft) {
    private lateinit var binding: FragmentNftBinding
    private val viewModel: NftViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNftBinding.bind(view)
        setup()
    }

    private fun setup() {

        viewModel.trappistInfo.observe(viewLifecycleOwner, Observer { nft ->
            nft?.let {
                binding.textViewCopyright.text = it.copyright
                binding.textViewDate.text = it.date
                binding.textViewTitle.text = it.title
                binding.textViewExplanation.text = it.explanation
                Picasso.get().load(it.hdurl).placeholder(R.drawable.error).error(R.drawable.error).into(binding.imageView)
            }
        })

        viewModel.fetchTrappistInfo()

    }
}