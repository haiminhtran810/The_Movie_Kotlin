package vn.home.app.themoviekotlin.ui.topSelling

import android.databinding.DataBindingUtil
import android.support.v7.util.DiffUtil
import android.support.v7.widget.PopupMenu
import android.view.Gravity
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.ViewGroup
import vn.home.app.themoviekotlin.BuildConfig
import vn.home.app.themoviekotlin.R
import vn.home.app.themoviekotlin.base.adapter.BaseRecyclerAdapter
import vn.home.app.themoviekotlin.data.model.Movie
import vn.home.app.themoviekotlin.databinding.ItemMovieBinding

class TopSellingAdapter(
        val itemClickMore: ((MenuItem) -> Unit)? = null, val itemClick: ((Movie) -> Unit)?) : BaseRecyclerAdapter<Movie, ItemMovieBinding>(DIFF_CALLBACK) {

    private companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie?, newItem: Movie?): Boolean {
                return oldItem!!.id.equals(newItem!!.id)
            }

            override fun areContentsTheSame(oldItem: Movie?, newItem: Movie?): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun createBinding(parent: ViewGroup, viewType: Int): ItemMovieBinding {
        val binding = DataBindingUtil.inflate<ItemMovieBinding>(
                LayoutInflater.from(parent.context), R.layout.item_movie, parent, false)
        return binding
    }

    override fun bind(binding: ItemMovieBinding, itemMovie: Movie, positionItem: Int) {
        binding.apply {
            item = itemMovie
            txtPoint.text = itemMovie.vote_average.toString()
            txtMoney.text = itemMovie.budget.toString() + "$"
            txtStt.text = positionItem.toString()
            url = BuildConfig.SMALL_IMAGE_URL + itemMovie.poster_path
            root.setOnClickListener {
                itemMovie?.apply {
                    itemClick?.invoke(this)
                }
            }

            imgOption.setOnClickListener {
                itemMovie?.apply {
                    //itemClickMore?.invoke(this)
                    val popup = PopupMenu(binding.root.context, binding.imgOption, Gravity.RIGHT)
                    //inflating menu from xml resource
                    popup.inflate(R.menu.menu_popup)
                    //adding click listener
                    popup.setOnMenuItemClickListener {
                        itemClickMore?.invoke(it)
                        false
                    }
                    popup.show()
                }
            }
        }


    }


}