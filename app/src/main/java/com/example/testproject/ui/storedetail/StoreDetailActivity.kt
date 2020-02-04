package com.example.testproject.ui.storedetail

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.testproject.R
import com.example.testproject.common.StringConst
import com.example.testproject.databinding.ActivityStoreDetailBinding



class StoreDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStoreDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_store_detail
        )

        binding.tvStoreTitle.text = intent.getStringExtra(StringConst.INTENT_KEY_TITLE)
        binding.tvStoreDescription.text = intent.getStringExtra(StringConst.INTENT_KEY_DESCRIPTION)
        Glide.with(this)
            .load(intent.getStringExtra(StringConst.INTENT_KEY_IMAGE_PATH))
            .into(binding.ivStore)


        val listImage: ArrayList<Int> = ArrayList()

        listImage.add(R.drawable.ic_launcher_background)
        listImage.add(R.drawable.ic_launcher_background)
        listImage.add(R.drawable.ic_launcher_background)
        listImage.add(R.drawable.ic_launcher_background)


    }
}
