package com.example.testproject

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.example.testproject.base.BaseRecyclerAdapter
import com.example.testproject.base.BaseViewHolder
import com.example.testproject.common.StringConst
import com.example.testproject.data.response.StoreData
import com.example.testproject.databinding.ItemMainBinding

class MainAdapter : BaseRecyclerAdapter<StoreData, MainAdapter.MainHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MainHolder(
        ItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )


    inner class MainHolder(private val binding: ItemMainBinding) :
        BaseViewHolder<StoreData>(binding.root) {
        private lateinit var item: StoreData

        init {
            binding.setOnClick {
                Intent(it.context, StoreDetailActivity::class.java).apply {
                    putExtra(StringConst.INTENT_KEY_TITLE, item.name)
                    putExtra(StringConst.INTENT_KEY_DESCRIPTION, item.description)
                }.run { it.context.startActivity(this) }
            }
        }

        override fun bind(item: StoreData) {
            this.item = item
            with(binding) {
                items = item
                executePendingBindings()
            }
        }
    }


}

private class DiffCallback : DiffUtil.ItemCallback<StoreData>() {
    override fun areItemsTheSame(oldItem: StoreData, newItem: StoreData): Boolean {
        return oldItem == newItem

    }

    override fun areContentsTheSame(oldItem: StoreData, newItem: StoreData): Boolean {
        return oldItem == newItem
    }

}