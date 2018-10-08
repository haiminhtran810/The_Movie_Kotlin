package vn.home.app.themoviekotlin.base.adapter

import android.databinding.ViewDataBinding
import android.support.v7.recyclerview.extensions.AsyncDifferConfig
import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.view.ViewGroup
import java.util.concurrent.Executors

abstract class BaseRecyclerAdapter<T, V : ViewDataBinding>
(callBack: DiffUtil.ItemCallback<T>) :
        ListAdapter<T, BaseViewHolder<V>>(AsyncDifferConfig.Builder<T>(callBack)
                .setBackgroundThreadExecutor(Executors.newSingleThreadExecutor())
                .build()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<V> {
        return BaseViewHolder(createBinding(parent, viewType))
    }

    override fun onBindViewHolder(holder: BaseViewHolder<V>, position: Int) {
        try {
            bind(holder.binding, getItem(position), position)
        } catch (e: Exception) {
            bind(holder.binding)
            e.printStackTrace()
        }
        holder.binding.executePendingBindings()
    }

    protected abstract fun createBinding(parent: ViewGroup, viewType: Int): V
    protected abstract fun bind(binding: V, item: T,position: Int)
    protected open fun bind(binding: V) {}
}