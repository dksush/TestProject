package com.example.testproject

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testproject.data.repository.RepoInterface
import com.example.testproject.data.response.StoreData

class MainViewModel(private val repoImpi: RepoInterface) : ViewModel() {

    val _renderItem = MutableLiveData<List<StoreData>>()
    val renderItem get() = _renderItem


    suspend fun requestList() {
        repoImpi.getList(1,
            success = {

                renderItem.value = it
                //Log.v("dksush_re", renderItem.value.toString())

            },
            fail = {

            })
    }

}