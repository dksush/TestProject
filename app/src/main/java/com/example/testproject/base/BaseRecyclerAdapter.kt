package com.example.testproject.base

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerAdapter<T, H : BaseViewHolder<T>>(diffCallback: DiffUtil.ItemCallback<T>) :
    ListAdapter<T, H>(diffCallback) {

    private val items: MutableList<T> = mutableListOf()

    override fun onBindViewHolder(holder: H, position: Int) {
        holder.bind(items[position])
      //  Log.v("dksush_pos", position.toString())
        //if (position == itemCount - 1) itemListener.loadMoreItems(currentList, itemCount + 1)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    open fun setData(items: List<T>) {
        this.items.clear()
        this.items.addAll(items)
        submitList(items)

    }

}


abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(item: T)
}