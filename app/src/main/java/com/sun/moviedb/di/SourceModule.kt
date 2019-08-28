package com.sun.moviedb.di

import com.sun.moviedb.base.ContextProviders
import com.sun.moviedb.data.DatabaseManager
import com.sun.moviedb.data.dao.GenresDao
import com.sun.moviedb.data.dao.MovieDao
import com.sun.moviedb.data.repository.DetailMovieRepository
import com.sun.moviedb.data.repository.HomeRepository
import com.sun.moviedb.data.repository.MovieByCategoryRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module

/**
 * Created by nguyenxuanhoi on 2019-08-14.
 * @author nguyen.xuan.hoi@sun-asterisk.com
 */
val sourceModule = module {
    single { ContextProviders() }

    single { DatabaseManager.appDatabase.genresDao() }

    single { DatabaseManager.appDatabase.movieDao() }

    single { HomeRepository(get(), get(named(RemoteProperties::class.java.name)), get()) }

    single { MovieByCategoryRepository(get(), get(named(RemoteProperties::class.java.name)), get()) }

    single { DetailMovieRepository(get(named(RemoteProperties.RX_ANDOIRD))) }

}
