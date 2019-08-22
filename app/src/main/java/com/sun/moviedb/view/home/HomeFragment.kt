package com.sun.moviedb.view.home

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.sun.moviedb.MainActivity
import com.sun.moviedb.R
import com.sun.moviedb.base.BaseResponse
import com.sun.moviedb.base.ViewModelBaseFragment
import com.sun.moviedb.data.dto.CategoryDTO
import com.sun.moviedb.data.entity.Movie
import com.sun.moviedb.databinding.FragmentHomeBinding
import com.sun.moviedb.utils.CategoryQuery
import com.sun.moviedb.view.adapter.GenresAdapter
import com.sun.moviedb.view.adapter.HomeAdapter
import com.sun.moviedb.view.widget.BackDropView
import com.sun.moviedb.view.widget.SpaceItemDecoration
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by nguyenxuanhoi on 2019-08-07.
 * @author nguyen.xuan.hoi@sun-asterisk.com
 */
class HomeFragment : ViewModelBaseFragment<HomeViewModel, FragmentHomeBinding>() {

    override val viewModel: HomeViewModel by viewModel()

    override val getContentViewId = R.layout.fragment_home

    override fun initializeView(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        setUpToolBar()
    }

    override fun initializeComponents() {
        initGenres()
        initCategory()

    }

    private fun initCategory() {
        val categories = viewModel.getCategories()
        val adapter = HomeAdapter({
            findNavController().navigate(R.id.actHomeToMovieByCategory)
        }, {
            findNavController().navigate(R.id.actHomeToDetail)
        })
        recyclerView.apply {
            setHasFixedSize(true)
            addItemDecoration(SpaceItemDecoration(resources.getDimensionPixelSize(R.dimen.dp_8)))
            this.adapter = adapter
        }
        adapter.submitList(categories)
        categories.forEach { category ->
            when (category.queryType) {
                CategoryQuery.POPULAR -> {
                    observeMovieByCategory(category, adapter, viewModel.moviesPopular)
                }
                CategoryQuery.NOW_PLAYING -> {
                    observeMovieByCategory(category, adapter, viewModel.moviesNowPlaying)
                }
                CategoryQuery.UP_COMING -> {
                    observeMovieByCategory(category, adapter, viewModel.moviesUpComming)
                }
                CategoryQuery.TOP_RATE -> {
                    observeMovieByCategory(category, adapter, viewModel.movieTopRate)
                }
            }

        }
    }

    private fun initGenres() {
        val adapterGenres = GenresAdapter {
            findNavController().navigate(R.id.actHomeToMovieByGenres)

        }
        recyclerGenres.apply {
            this.adapter = adapterGenres
        }
        viewModel.genres.observe(this, Observer {
            handlerError(it)
            it.result?.let { genres ->
                adapterGenres.submitList(genres)
            }
        })
    }

    private fun observeMovieByCategory(
        category: CategoryDTO,
        adapter: HomeAdapter, data:
        LiveData<BaseResponse<List<Movie>>>
    ) {
        data.observe(this, Observer {
            handlerError(it)
            it.result?.let { movies ->
                category.movies = movies
                adapter.notifyDataSetChanged()
            }
        })
    }

    override fun onBackPressed(): Boolean {
        if (drawer.isDrawerOpen(GravityCompat.END)) {
            drawer.closeDrawer(GravityCompat.END)
            return true
        }
        return false
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_main, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem) =
        when (item.itemId) {
            R.id.menu_search -> {
                findNavController().navigate(R.id.actHomeToSearch)
                true
            }
            R.id.menu_filter -> {
                drawer.openDrawer(GravityCompat.END)
                true

            }
            else -> super.onOptionsItemSelected(item)

        }

    private fun setUpToolBar() {
        (activity as MainActivity).setSupportActionBar(toolBar)
        toolBar.setNavigationOnClickListener(
            BackDropView(
                context!!, home, AccelerateDecelerateInterpolator(),
                ContextCompat.getDrawable(context!!, R.drawable.ic_menu),
                ContextCompat.getDrawable(context!!, R.drawable.ic_close_menu)
            )
        )
    }
}
