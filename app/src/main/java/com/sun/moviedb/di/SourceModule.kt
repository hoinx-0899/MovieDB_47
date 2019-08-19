package com.sun.moviedb.di

import com.sun.moviedb.base.ContextProviders
import com.sun.moviedb.data.repository.HomeRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module

/**
 * Created by nguyenxuanhoi on 2019-08-14.
 * @author nguyen.xuan.hoi@sun-asterisk.com
 */
val sourceModule= module {
    single(named(ContextProviders::class.java.name)) { ContextProviders() }

    single(named(HomeRepository::class.java.name)) { HomeRepository(get(named(ContextProviders::class.java.name)),
        get(named(RemoteProperties::class.java.name))) }
}
