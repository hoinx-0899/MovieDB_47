package com.sun.moviedb.view.home

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import com.sun.moviedb.MainActivity
import com.sun.moviedb.R
import com.sun.moviedb.base.ViewModelBaseFragment
import com.sun.moviedb.databinding.FragmentHomeBinding
import com.sun.moviedb.view.adapter.GenresAdapter
import com.sun.moviedb.view.widget.BackDropView
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
        val adapterGenres = GenresAdapter {

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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_main, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    private fun setUpToolBar() {
        (activity as MainActivity).setSupportActionBar(toolBar)
        toolBar.setNavigationOnClickListener(
                BackDropView(context!!, home, AccelerateDecelerateInterpolator(),
                        ContextCompat.getDrawable(context!!, R.drawable.ic_menu),
                        ContextCompat.getDrawable(context!!, R.drawable.ic_close_menu)))
    }
}
