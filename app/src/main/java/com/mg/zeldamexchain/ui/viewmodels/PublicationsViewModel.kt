package com.mg.zeldamexchain.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mg.zeldamexchain.data.model.Publication
import com.mg.zeldamexchain.data.network.ApiDbClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PublicationsViewModel : ViewModel() {
    var publicationList: ArrayList<Publication> = arrayListOf()
    var list = MutableLiveData<ArrayList<Publication>>()

    init {
        getPublicationsList()
    }

    private fun getPublicationsList() {
        CoroutineScope(Dispatchers.IO).launch{
            val call = ApiDbClient.service.getPublications("publicationsnfts")
            val publication = call.execute().body()
            publicationList = ((publication?.publication ?: emptyList()) as ArrayList<Publication>)
            list.postValue(publicationList)

        }
    }
}