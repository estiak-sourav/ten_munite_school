package com.sourav.tenmuniteschool.adapters

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sourav.tenmuniteschool.R
import com.sourav.tenmuniteschool.modes.ChapterList

class ChapterMainAdapter(context: Context, private var chapterMainLists: MutableList<ChapterList>) :
    RecyclerView.Adapter<ChapterMainAdapter.ViewHolder>() {
    private var context: Context = context
    private lateinit var chapterDetailsAdapter: ChapterDetailsAdapter

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_chapter_main, parent, false)
        return ViewHolder(itemView)
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val homeMainList = chapterMainLists[position]

        holder.chapterRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        holder.titleTv.text = "  "+homeMainList.title

        val chapterDetailsList = homeMainList.subItem

        chapterDetailsAdapter = ChapterDetailsAdapter(context, chapterDetailsList)
        holder.chapterRv.adapter = chapterDetailsAdapter

    }

    override fun getItemCount(): Int {
        return chapterMainLists.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var titleTv: TextView = itemView.findViewById(R.id.titleTv)
        var chapterRv: RecyclerView = itemView.findViewById(R.id.chapter_item_rv)

    }

}