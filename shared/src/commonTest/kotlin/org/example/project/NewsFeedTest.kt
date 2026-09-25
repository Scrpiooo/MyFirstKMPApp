package org.example.project

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.flow.toList

class NewsFeedTest {

    @Test
    fun testNewsFlow() = runTest {
        val news = newsFlow().toList()

        assertEquals(3, news.size)
        assertEquals("Teknologi", news[0].category)
        assertEquals("Kesenian", news[1].category)
    }

    @Test
    fun testDetailNews() = runTest {
        val result = detailNews(1)

        assertEquals("Detail berita dengan id 1", result)
    }
}

