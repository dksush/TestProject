package com.example.testproject.data.repository

import com.example.testproject.data.datasource.RemoteDsInterface
import com.example.testproject.data.response.StoreData

class RepoImpi(private val remoteDs: RemoteDsInterface) : RepoInterface {
    override suspend fun getList(
        page: Int,
        success: (result: List<StoreData>) -> Unit,
        fail: (Throwable) -> Unit
    ) {
        remoteDs.getList(
            page,
            { success(it) },
            fail
        )
    }

    override fun getSearchStore(
        q: String,
        success: (result: List<StoreData>) -> Unit,
        fail: (Throwable) -> Unit
    ) {
        remoteDs.getSearchStore(
            q,
            { success(it) },
            fail
        )

    }


}