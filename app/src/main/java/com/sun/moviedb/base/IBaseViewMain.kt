package com.sun.moviedb.base

import android.os.Bundle
import androidx.annotation.LayoutRes

interface IBaseViewMain {
    val getContentViewId: Int
    fun initializeView(savedInstanceState: Bundle?)
    fun initializeComponents()
}
