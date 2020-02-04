package com.example.testproject.ui.main

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.testproject.R
import com.example.testproject.common.toast
import com.example.testproject.data.datasource.RemoteDsImpi
import com.example.testproject.data.repository.RepoImpi
import com.example.testproject.data.response.StoreData
import com.example.testproject.databinding.ActivityMainBinding
import com.example.testproject.ui.base.BaseRecyclerAdapter
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {


    private val remoteDsImpi by lazy {
        RemoteDsImpi()
    }
    private val remoteDataSource by lazy {
        RepoImpi(
            remoteDs = remoteDsImpi
        )
    }
    private val vm by lazy {
        MainViewModel(
            remoteDataSource
        )
    }

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainAdapter: MainAdapter
    private var page: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_main
        )

        binding.vm = vm
        binding.lifecycleOwner = this

        binding.recycle.run {
            mainAdapter = MainAdapter(object :
                BaseRecyclerAdapter.ItemListener<StoreData> {
                override fun loadMoreItems(list: List<StoreData>, index: Int) {
                    page += 1
                    lifecycleScope.launch {
                        vm.requestList(page)
                    }
                }

            })
            adapter = mainAdapter
            addItemDecoration(
                DividerItemDecoration(
                    this@MainActivity,
                    DividerItemDecoration.VERTICAL
                )
            )

        }

        //최초 리스트 요청
        lifecycleScope.launch {
            vm.requestList(page)
        }

        observeListener()

    }
    private fun observeListener(){
        vm.emptyList.observe(this, Observer {
            this.toast(getString(R.string.empty_store_list))
        })

        vm.inputKeyword.observe(this, Observer {
            if(TextUtils.isEmpty(it)){
                lifecycleScope.launch {
                    page = 0
                    vm.requestList(page)
                }

            }else{
                vm.requestStore(it)
            }
        })
    }


}
