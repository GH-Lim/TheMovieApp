package com.example.themovieapp.ui

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.themovieapp.R
import com.example.themovieapp.utils.inflate
import kotlinx.android.synthetic.main.frag_recycler.*

class MovieFragment : Fragment() {

    private val movieList by lazy { rv_movie_list }  // 안드로이드 코틀린 확장의 합성 프로퍼티 기법

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return container?.inflate(R.layout.frag_recycler)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // RecyclerView 의 리소스 id
        rv_movie_list.apply {
            setHasFixedSize(true) // this.. 즉 rv_movie_list.setHasFixedSize() 와 같다
            val linearLayout = LinearLayoutManager(context)
            layoutManager = linearLayout // this.layoutManager
        }

//        val movieList by lazy {
//            movie_list.setHasFixedSize(true)
//            movie_list.layoutManager = LinearLayoutManager(context)
//            movie_list // 리턴 사료형으로서 사용된다
//        }

//        movieList.setHasFixedSize(true)  // lazy 접근 실행
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            movieList.layoutManager = LinearLayoutManager(context)
//        }
    }
}