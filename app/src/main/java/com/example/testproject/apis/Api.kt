package com.example.testproject.apis

import com.example.testproject.data.response.StoreData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    companion object {
        const val BASE_URL: String = "https://dailyshot.co/v1/"
    }


    @GET("bar_list")
    fun getInfo(
        @Query("page") page: Int
    ): Call<List<StoreData>>


}