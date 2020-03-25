package com.example.themovieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.themovieapp.ui.MovieFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        if (savedInstanceState == null) {
            changeFragment(MovieFragment())
        }
    }

    fun changeFragment(f: Fragment, cleanStack: Boolean = false) {
        // 자바에서는
        // FragmentManager fragmentManager = getFragmentManager()
        // FragmentTransaction ft = fragmentManager.beginTransaction()
        // 코틀린에서는 아래 한 줄
        val ft = supportFragmentManager.beginTransaction()  // 프레그먼트 관리자를 통한 제어
        ft.replace(R.id.base_content, f) // 프래그먼트 변경
        ft.addToBackStack(null) // 백스택에 넣기
        ft.commit() // 최종 프래그먼트 적용
    }
}
