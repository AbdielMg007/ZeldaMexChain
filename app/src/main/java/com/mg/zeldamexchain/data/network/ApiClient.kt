package com.mg.zeldamexchain.data.network

import com.mg.zeldamexchain.data.model.CallPublications
import com.mg.zeldamexchain.data.model.Nft
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url


interface ApiClient {

    @GET
    fun getPublications(@Url url:String): Call<CallPublications>

    @GET
    fun getNft(@Url url:String): Call<Nft>

}