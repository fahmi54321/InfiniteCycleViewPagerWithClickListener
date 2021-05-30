package com.android.a102infinitecycleviewpagerwithclicklistener

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager

class MainActivity : AppCompatActivity() {

    internal var movieList:MutableList<Movie> = ArrayList()
    var viewPager:HorizontalInfiniteCycleViewPager?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()
        viewPager = findViewById(R.id.view_pager)
        val adapter = MyAdapter(this,movieList)
        viewPager?.adapter = adapter

    }

    private fun initData() {
        movieList.add(Movie("Fahmi",getString(R.string.long_text),R.drawable.fahmi))
        movieList.add(Movie("Scoot",getString(R.string.long_text),R.drawable.scoot))
        movieList.add(Movie("Yen",getString(R.string.long_text),R.drawable.yen))
    }
}