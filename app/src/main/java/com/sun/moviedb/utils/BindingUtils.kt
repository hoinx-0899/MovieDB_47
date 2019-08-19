package com.sun.moviedb.utils

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.sun.moviedb.MovieApplication
import com.sun.moviedb.R

/**
 * Created by nguyenxuanhoi on 2019-08-17.
 * @author nguyen.xuan.hoi@sun-asterisk.com
 */
object BindingUtils {
    @BindingAdapter("android:text")
    @JvmStatic
    fun bindTextView(textView: TextView,title:String){
            textView.text=title
    }
}
