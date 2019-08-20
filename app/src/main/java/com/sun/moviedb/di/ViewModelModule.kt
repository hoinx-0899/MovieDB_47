package com.sun.moviedb.di

import com.sun.moviedb.MovieApplication
import com.sun.moviedb.data.repository.HomeRepository
import com.sun.moviedb.data.repository.MovieByCategoryRepository
import com.sun.moviedb.view.childhome.ChildHomeViewModel
import com.sun.moviedb.view.home.HomeViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

/**
 * Created by nguyenxuanhoi on 2019-08-07.
 * @author nguyen.xuan.hoi@sun-asterisk.com
 */
val viewModelModule = module {
    single(named(MovieApplication::class.java.name)) { androidApplication() }

    viewModel { HomeViewModel(get(named(MovieApplication::class.java.name)), get()) }

    viewModel { ChildHomeViewModel(get(named(MovieApplication::class.java.name)), get()) }

}