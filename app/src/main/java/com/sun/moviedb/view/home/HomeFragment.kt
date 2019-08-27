package com.sun.moviedb.view.home

import android.content.res.Configuration
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.TooltipCompat
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.core.view.GravityCompat
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.navOptions
import com.sun.moviedb.MainActivity
import com.sun.moviedb.R
import com.sun.moviedb.base.ViewModelBaseFragment
import com.sun.moviedb.constants.Constants
import com.sun.moviedb.databinding.FragmentHomeBinding
import com.sun.moviedb.utils.CategoryQuery
import com.sun.moviedb.view.adapter.GenresAdapter
import com.sun.moviedb.view.widget.BackDropView
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.layout_menu.*
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by nguyenxuanhoi on 2019-08-07.
 * @author nguyen.xuan.hoi@sun-asterisk.com
 */
class HomeFragment : ViewModelBaseFragment<HomeViewModel, FragmentHomeBinding>(), View.OnClickListener {

    private val navController: NavController
        get() = (childFragmentManager.findFragmentById(R.id.hostHomeNav) as NavHostFragment).navController

    override val viewModel: HomeViewModel by viewModel()

    override val getContentViewId = R.layout.fragment_home

    override fun initializeView(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        setUpToolBar()
    }

    override fun initializeComponents() {
        initGenres()
    }

    private fun initGenres() {
        val adapterGenres = GenresAdapter {
            drawer.closeDrawer(GravityCompat.END)
            val bundle = bundleOf()
            navigate(R.id.movieByGenresFragment, bundle)

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

    override fun registerListeners() {
        buttonNowPlaying.setOnClickListener(this)
        buttonTopRate.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when (v) {
            buttonNowPlaying -> {
                val bundle = bundleOf(BUNDLE_QUERY to CategoryQuery.NOW_PLAYING)
                navigate(R.id.movieByCategoryFragment, bundle)
            }
            buttonTopRate -> {
                val bundle = bundleOf(BUNDLE_QUERY to CategoryQuery.TOP_RATE)
                navigate(R.id.movieByCategoryFragment, bundle)
            }
        }

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
        val toggleTheme = menu.findItem(R.id.menu_theme)
        toggleDarkTheme(toggleTheme)
        super.onCreateOptionsMenu(menu, inflater)
    }

    private fun toggleDarkTheme(toggleTheme: MenuItem) {
        (toggleTheme.actionView as CheckBox?)?.apply {
            setButtonDrawable(R.drawable.ic_dark_theme)
            isChecked = isDarkTheme()
            jumpDrawablesToCurrentState()
            setOnCheckedChangeListener { _, isChecked ->
                postDelayed({
                    AppCompatDelegate.setDefaultNightMode(
                            if (isChecked) AppCompatDelegate.MODE_NIGHT_YES
                            else AppCompatDelegate.MODE_NIGHT_NO)
                    (activity as MainActivity).delegate.applyDayNight()
                }, Constants.TIME_DELAY_CHANGE_MODE)
            }
        }
    }

    private fun isDarkTheme(): Boolean {
        return context!!.resources.configuration.uiMode and
                Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.menu_search -> {
            navigate(R.id.searchFragment, null)
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
        toolBar.setNavigationOnClickListener(BackDropView(
                context!!, home, AccelerateDecelerateInterpolator(),
                ContextCompat.getDrawable(context!!, R.drawable.ic_menu),
                ContextCompat.getDrawable(context!!, R.drawable.ic_close_menu))
        )
    }

    private fun navigate(id: Int, bundle: Bundle?) {
        if (navController.currentDestination?.id != id) {
            navController.navigate(id, bundle, navOptions {
                anim {
                    enter = R.anim.slide_in_right
                    exit = R.anim.slide_out_left
                    popEnter = R.anim.slide_in_left
                    popExit = R.anim.slide_out_right
                }
                popUpTo = navController.graph.startDestination
                launchSingleTop = true
            })
        }
    }
    companion object{
        const val BUNDLE_QUERY = "query"
    }
}
