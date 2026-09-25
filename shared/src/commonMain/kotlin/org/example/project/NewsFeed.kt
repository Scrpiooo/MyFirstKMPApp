package org.example.project

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.catch

data class News(
    val id: Int,
    val title: String,
    val category: String,
    val content: String
    )

fun newsFlow(): Flow<News> = flow {
    emit(News(1, "Langkah Unik Bandai Namco di Tekken 8", "Teknologi", "Studio game raksasa Bandai Namco membuka " +
            "lowongan pekerjaan langsung di dalam game (in-game) Tekken 8. Langkah langka ini memicu spekulasi besar di kalangan komunitas gamer mengenai " +
            "masa depan arah pengembangan game fighting tersebut"))
    delay(2000)

    emit(News(2, "Karya Kreatif HUT RI Berbasis Gemini AI", "Kesenian", " Tren pembuatan karya seni digital berbasis " +
            "prompt Gemini AI banyak digunakan untuk menghasilkan visual bertema kemerdekaan yang estetik dan bernilai seni tinggi secara instan."))
    delay(2000)

    emit(News(3, "Dilema Etis AI bagi Developer Lokal", "Teknologi", " Studio game terbesar di Indonesia, Agate, " +
            "mengungkapkan bahwa mereka mulai berhati-hati memanfaatkan Generative AI. Meski AI sangat membantu mempercepat proses coding dan pembuatan " +
            "latar belakang (background), Agate menegaskan hasil akhir visual tetap dikerjakan manusia demi menghindari isu pelanggaran hak cipta aset digital."))
}

suspend fun showNews(newsCount: NewsCount) = coroutineScope{
    newsFlow()
        .filter { news -> news.category == "Teknologi" }
        .map { news ->
            Pair ( news.id, "[${news.category}] ${news.title}" ) }
        .catch { e ->
            println("Terjadi error : ${e.message}")
        }
        .collect { news ->
            println(news.second)

            try {
                val detail = async {
                    detailNews(news.first)
                }

                println(detail.await())
            }catch ( e : Exception ){
                println("Gagal memuat detail: ${e.message}")
            }

            newsCount.markRead()
        }
}

suspend fun detailNews(newsId : Int): String {
    delay(1000)
    return "Detail berita dengan id $newsId"
}

