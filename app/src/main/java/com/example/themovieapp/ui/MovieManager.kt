package com.example.themovieapp.ui

class MovieManager() {
    fun getMovieList(): Observable<List<MovieItem>> { // Observable은 주로 생산자를 의미한다.
        return Observable.create { subscriber -> // 데이터 생성을 위한 create
            val movieList = mutableListOf<MovieItem>()
            for (i in 1..10) {
                movieList.add(
                    MovieItem(
                        1234,
                        5.0f,
                        "Test Title $i",
                        "2018-01-01",
                        "https://picsum.photos/480/640?image=$i",
                        "Test Overview"
                    )
                )
            }
            subscriber.onNext(movieList) // 구독자(관찰자)에게 데이터의 발행을 알린다.
            subscriber.onComplete() // 모든 데이터의 발행이 완료되었음을 알린다.
        }
    }
}