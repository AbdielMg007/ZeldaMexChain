package com.mg.zeldamexchain.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mg.zeldamexchain.R
import com.mg.zeldamexchain.data.model.Publication
import com.mg.zeldamexchain.databinding.CardPublicationBinding
import com.squareup.picasso.Picasso

class AdapterPublication(private var publication: ArrayList<Publication>) : RecyclerView.Adapter<AdapterPublication.PublicationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PublicationViewHolder {
        val binding = CardPublicationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PublicationViewHolder(binding)
    }



    override fun onBindViewHolder(holder: PublicationViewHolder, i: Int) {
        holder.bind(publication[i])
    }

    override fun getItemCount(): Int = publication.size

    class PublicationViewHolder(val binding: CardPublicationBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(publication: Publication) {
            Picasso.get().load(publication.photo).placeholder(R.drawable.error).error(R.drawable.error).into(binding.photoImg)
            binding.footerTv.text = publication.footer
            binding.authorTv.text = publication.author
            binding.dateTv.text = publication.date
        }
    }

    fun updateItems(newItems: ArrayList<Publication>) {
        publication.clear()
        publication.addAll(newItems)
        notifyDataSetChanged()
    }
}