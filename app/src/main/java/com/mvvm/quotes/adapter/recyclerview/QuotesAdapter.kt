package com.mvvm.quotes.adapter.recyclerview

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mvvm.quotes.R
import com.mvvm.quotes.model.Quote
import java.util.*
import kotlin.collections.ArrayList


class QuotesAdapter(val quoteList: ArrayList<Quote>) : RecyclerView.Adapter<QuotesAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val author: TextView
        val content: TextView
        val rootView: View
        init {
            author = itemView.findViewById(R.id.author)
            content = itemView.findViewById(R.id.content)
            rootView = itemView.findViewById(R.id.quote_container)
//            val startColor = Int[]
            val spacing = itemView.resources.getDimensionPixelSize(R.dimen._10sdp)
            val gd = GradientDrawable(
                GradientDrawable.Orientation.TOP_BOTTOM, intArrayOf(getRandomColor(), getRandomColor())
            )
            gd.cornerRadius = spacing.toFloat()

            rootView.background = gd



        }

        fun getRandomColor(): Int {
            val rnd = Random()
            return Color.argb(255, rnd.nextInt(256), rnd.nextInt(56), rnd.nextInt(256))
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.quote_cell, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val quote = quoteList[position]
        holder.content.text = quote.quote
        holder.author.text = quote.author
    }

    override fun getItemCount(): Int {
        return quoteList.size
    }


}