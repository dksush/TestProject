package com.example.testproject.data.datasource

import android.util.Log
import com.example.testproject.apis.NetworkUtil
import com.example.testproject.data.response.StoreData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDsImpi : RemoteDsInterface {
    override suspend fun getList(
        page: Int,
        success: (result: List<StoreData>) -> Unit,
        fail: (Throwable) -> Unit
    ) {
        NetworkUtil.apiService.getInfo(page)
            .enqueue(object : Callback<List<StoreData>> {
                override fun onFailure(call: Call<List<StoreData>>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<List<StoreData>>,
                    response: Response<List<StoreData>>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.let {
                            success(it)
                        }
                    }
                }

            })
    }

    override fun getSearchStore(
        q: String,
        success: (result: List<StoreData>) -> Unit,
        fail: (Throwable) -> Unit
    ) {
        NetworkUtil.apiService.getSearchStore(q)
            .enqueue(object :Callback<List<StoreData>>{
                override fun onFailure(call: Call<List<StoreData>>, t: Throwable) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onResponse(
                    call: Call<List<StoreData>>,
                    response: Response<List<StoreData>>
                ) {

                    if (response.isSuccessful) {
                        response.body()?.let {
                            success(it)
                        }
                    }
                }

            })
    }


}