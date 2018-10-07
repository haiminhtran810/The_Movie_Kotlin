package vn.home.app.themoviekotlin.ui.topSelling

import android.databinding.DataBindingUtil
import android.support.v7.util.DiffUtil
import android.view.LayoutInflater
import android.view.ViewGroup
import vn.home.app.themoviekotlin.R
import vn.home.app.themoviekotlin.base.adapter.BaseRecycleAdapter
import vn.home.app.themoviekotlin.data.model.Movie
import vn.home.app.themoviekotlin.databinding.ItemMovieBinding

class TopSellingAdapter : BaseRecycleAdapter<Movie, ItemMovieBinding>(
        object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie?, newItem: Movie?): Boolean {
                return oldItem!!.id == newItem!!.id
            }

            override fun areContentsTheSame(oldItem: Movie?, newItem: Movie?): Boolean {
                return oldItem == newItem
            }

        }
) {

    override fun createBinding(parent: ViewGroup, viewType: Int): ItemMovieBinding {
        val binding = DataBindingUtil.inflate<ItemMovieBinding>(LayoutInflater.from(parent.context), R.layout.item_movie, parent, false)
        return binding
    }

    override fun bind(binding: ItemMovieBinding, item: Movie) {
        binding.item = item
    }

}