package com.android.a102infinitecycleviewpagerwithclicklistener

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.viewpager.widget.PagerAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MyAdapter(
    internal var context:Context,
    internal var movieList:List<Movie>,
):PagerAdapter() {
    override fun getCount(): Int {
        return movieList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(context).inflate(R.layout.card_item,container,false)

        val moview_image = view.findViewById<View>(R.id.movie_image) as ImageView
        val moview_title = view.findViewById<View>(R.id.movie_title) as TextView
        val moview_description = view.findViewById<View>(R.id.movie_description) as TextView
        val btn_fav = view.findViewById<View>(R.id.btn_fav) as FloatingActionButton

        moview_image.setImageResource(movieList[position].image)
        moview_title.text = movieList[position].name
        moview_description.text = movieList[position].description

        view.setOnClickListener {
            Toast.makeText(context, ""+movieList[position].name, Toast.LENGTH_SHORT).show()
        }

        btn_fav.setOnClickListener {
            Toast.makeText(context, "Button Clicked, Add to Fav", Toast.LENGTH_SHORT).show()
        }
        container.addView(view)
        return view
    }
}