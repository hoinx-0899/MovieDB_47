package com.sun.moviedb.view.adapter

import androidx.recyclerview.widget.DiffUtil
import com.sun.moviedb.MovieApplication
import com.sun.moviedb.R
import com.sun.moviedb.base.BaseRecyclerAdapter
import com.sun.moviedb.data.dto.CategoryDTO
import com.sun.moviedb.databinding.ItemHomeMovieBinding
import com.sun.moviedb.view.widget.SpaceItemDecoration

/**
 * Created by nguyenxuanhoi on 2019-08-16.
 * @author nguyen.xuan.hoi@sun-asterisk.com
 */
class HomeAdapter(val onItemClicked: (category: CategoryDTO) -> Unit) :
    BaseRecyclerAdapter<CategoryDTO, ItemHomeMovieBinding>(object : DiffUtil.ItemCallback<CategoryDTO>() {
        override fun areContentsTheSame(oldItem: CategoryDTO, newItem: CategoryDTO): Boolean {
            return oldItem.equals(newItem)
        }

        override fun areItemsTheSame(oldItem: CategoryDTO, newItem: CategoryDTO): Boolean =
            oldItem.queryType == newItem.queryType

    }) {

    override fun getLayoutRes(viewType: Int): Int = R.layout.item_home_movie

    override fun bindFirstTime(binding: ItemHomeMovieBinding) {
        val movieHomeAdapter = MovieHomeAdapter()
        binding.apply {
            recyclerMovie.addItemDecoration(
                SpaceItemDecoration(MovieApplication.applicationContext!!.resources.getDimensionPixelSize(R.dimen.dp_4))
            )
            recyclerMovie.setHasFixedSize(true)
            recyclerMovie.adapter = movieHomeAdapter
        }
    }
}
