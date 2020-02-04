package com.example.testproject.ui.base

import android.view.View
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerAdapter<T, H : BaseViewHolder<T>>(
    private val itemListener: ItemListener<T>,
    diffCallback: DiffUtil.ItemCallback<T>
) :
    ListAdapter<T, H>(diffCallback) {

    internal val itemList: MutableList<T> = mutableListOf()
    internal val searchItemList: MutableList<T> = mutableListOf()

    override fun onBindViewHolder(holder: H, position: Int) {
        holder.bind(itemList[position])
        if (position == itemCount - 1 && itemCount >= 10) itemListener.loadMoreItems(
            currentList, itemCount + 1
        )
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    open fun setData(items: List<T>) {
        this.itemList.addAll(items)
        notifyDataSetChanged()

    }

    open fun searchData(items: List<T>) {
        this.itemList.clear()
        this.itemList.addAll(items)
        notifyDataSetChanged()

    }

    interface ItemListener<T> {
        fun loadMoreItems(list: List<T>, index: Int)
    }
}


abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(item: T)
}