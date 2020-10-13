package com.sourav.tenmuniteschool.activitys

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.sourav.tenmuniteschool.R
import com.sourav.tenmuniteschool.adapters.ChapterMainAdapter
import com.sourav.tenmuniteschool.modes.ChapterList
import com.sourav.tenmuniteschool.modes.SubItem
import kotlinx.android.synthetic.main.activity_chapter.*

class ChapterActivity : AppCompatActivity() {
    lateinit var chapterMainAdapter: ChapterMainAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter)

        title = "Chapter"

        chapterMainRv.layoutManager = LinearLayoutManager(this)

        val chapterOne = mutableListOf(
                SubItem("Video 1_1"),
                SubItem("Document 1_1"),
                SubItem("Video 1_2")
        )

        val chapterTwo = mutableListOf(
                SubItem("Document 2_1"),
                SubItem("Video 2_1"),
                SubItem("Video 2_2"),
                SubItem("Audio 2_1")
        )

        val emptyList = mutableListOf<SubItem>()

        val chapterList = mutableListOf(
                ChapterList("Chapter","Chapter 1", chapterOne),
                ChapterList("Chapter","Chapter 2", chapterTwo),
                ChapterList("Chapter","Video 3_0", emptyList),
                ChapterList("Chapter","Document 4_0", emptyList),
        )



        chapterMainAdapter = ChapterMainAdapter(applicationContext, chapterList)
        chapterMainRv.adapter = chapterMainAdapter
    }
}