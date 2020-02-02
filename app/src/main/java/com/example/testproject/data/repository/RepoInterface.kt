package com.example.testproject.data.repository

import com.example.testproject.data.response.StoreData

interface RepoInterface {

    suspend fun getList(
        page : Int,
        success: (result: List<StoreData>) -> Unit,
        fail: (Throwable) -> Unit

    )
}