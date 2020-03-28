package com.example.themovieapp.data

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * 각각의 영화 아이템을 위한 데이터 클래스 정의
 * @property vote_count 투표수
 * @property vote_average 투표 평균 점수
 * @property title 영화명
 * @property release_date 출시일
 * @property poster_path 포스터의 위치
 * @property overview 영화 설명
 */
@Parcelize
data class MovieItem(
    val vote_count: Int,
    val vote_average: Float,
    val title: String,
    val release_date: String,
    val poster_path: String,
    val overview: String?
) : Parcelable {
}