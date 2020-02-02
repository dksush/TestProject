package com.example.testproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.testproject.data.datasource.RemoteDsImpi
import com.example.testproject.data.repository.RepoImpi
import com.example.testproject.databinding.ActivityMainBinding
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.vm = vm
        binding.lifecycleOwner = this

        binding.recycle.run {
            mainAdapter = MainAdapter()
            adapter = mainAdapter
            addItemDecoration(
                DividerItemDecoration(
                    this@MainActivity,
                    DividerItemDecoration.VERTICAL
                )
            )

        }


        lifecycleScope.launch {
            vm.requestList()
        }

    }
}
