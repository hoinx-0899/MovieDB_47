package com.sun.moviedb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sun.moviedb.base.BaseActivity

class MainActivity : BaseActivity() {

    override val getContentViewId: Int = R.layout.activity_main

    override fun initializeView(savedInstanceState: Bundle?) {
    }

    override fun initializeComponents() {
    }
}
