package vn.home.app.themoviekotlin.base.adapter

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView

open class BaseViewHolder<T : ViewDataBinding> constructor(val binding: T) : RecyclerView.ViewHolder(binding.root)