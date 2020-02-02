package com.example.testproject.data.datasource

import com.example.testproject.data.response.StoreData

interface RemoteDsInterface {

    suspend fun getList(
        page: Int,
        success: (result: List<StoreData>) -> Unit,
        fail: (Throwable) -> Unit

    )
}