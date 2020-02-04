package com.example.testproject.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testproject.data.repository.RepoInterface
import com.example.testproject.data.response.StoreData

class MainViewModel(private val repoImpi: RepoInterface) : ViewModel() {

    val _renderItem = MutableLiveData<List<StoreData>>()
    val renderItem get() = _renderItem

    val _searchItem = MutableLiveData<List<StoreData>>()
    val searchRenderItem get() = _searchItem


    val emptyList = MutableLiveData<Unit>()
    var inputKeyword = MutableLiveData<String>()
    val isprogressbar = MutableLiveData<Boolean>(false)


    suspend fun requestList(page: Int) {
        isprogressbar.value = true
        repoImpi.getList(page,
            success = {
                isprogressbar.value = false
                if (it.isEmpty())
                    emptyList.value = Unit
                else
                    renderItem.value = it

            },
            fail = {

            })
    }

    fun requestStore(text: String) {
        isprogressbar.value = true
        repoImpi.getSearchStore(text,
            success = {
                isprogressbar.value = false
                if (it.isNotEmpty())
                    searchRenderItem.value = it
            },
            fail = {

            })
    }


}