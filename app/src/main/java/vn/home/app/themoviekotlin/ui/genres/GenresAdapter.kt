package vn.home.app.themoviekotlin.ui.genres

import android.databinding.DataBindingUtil
import android.support.v7.util.DiffUtil
import android.view.LayoutInflater
import android.view.ViewGroup
import vn.home.app.themoviekotlin.R
import vn.home.app.themoviekotlin.base.adapter.BaseRecyclerAdapter
import vn.home.app.themoviekotlin.data.model.Genre
import vn.home.app.themoviekotlin.databinding.ItemGenreBinding

class GenresAdapter : BaseRecyclerAdapter<Genre, ItemGenreBinding>(DIFF_CALLBACK) {

    private companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Genre>() {
            override fun areItemsTheSame(oldItem: Genre?, newItem: Genre?): Boolean {
                return oldItem!!.id.equals(newItem!!.id)
            }

            override fun areContentsTheSame(oldItem: Genre?, newItem: Genre?): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun createBinding(parent: ViewGroup, viewType: Int): ItemGenreBinding {
        val binding = DataBindingUtil.inflate<ItemGenreBinding>(
                LayoutInflater.from(parent.context), R.layout.item_genre, parent, false)
        return binding
    }

    override fun bind(binding: ItemGenreBinding, item: Genre, position: Int) {
        binding.txtNameGenres.text = item.name
    }


}