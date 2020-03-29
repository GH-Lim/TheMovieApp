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
import com.example.themovieapp.data.MovieItem
import com.example.themovieapp.ui.adapter.MovieAdapter
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
        // (1) 어댑터의 연결
        if (rv_movie_list.adapter == null) {
            rv_movie_list.adapter = MovieAdapter()
        }
        // (2) 테스트용 데이터의 생성
        if (savedInstanceState == null) {
            val movieList = mutableListOf<MovieItem>()
            for (i in 1..10) {
                movieList.add(
                    MovieItem(
                        1234,
                        5.0f,
                        "Test Title $i",
                        "2018-01-01",
                        "https://picsum.photos/480/640?image=$i", // (3) 외부 인터넷 이미지 리소스
                        "Test Overview"
                    )
                )
            }
            // (4) 생성된 데이터를 RecyclerView에 추가
            (rv_movie_list.adapter as MovieAdapter).addMovieList(movieList)
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