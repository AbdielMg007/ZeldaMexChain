package com.mg.zeldamexchain.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mg.zeldamexchain.data.model.Nft
import com.mg.zeldamexchain.data.network.ApiDbClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NftViewModel : ViewModel(){

    private val nasaApiService = ApiDbClient.service

    private val _trappistInfo = MutableLiveData<Nft>()

    val trappistInfo: LiveData<Nft> = _trappistInfo

    fun fetchTrappistInfo() {

        val call = nasaApiService.getNft("nft")

        call.enqueue(object : Callback<Nft> {
            override fun onResponse(call: Call<Nft>, response: Response<Nft>) {
                if (response.isSuccessful) {
                    _trappistInfo.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<Nft>, t: Throwable) {
                // Todo
            }
        })
    }

}

