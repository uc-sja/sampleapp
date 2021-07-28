package com.mvvm.quotes.adapter.recyclerview

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.mvvm.quotes.R
import com.mvvm.quotes.model.pojo.Quote
import com.mvvm.quotes.view.fragment.QuoteListFragmentDirections
import java.util.*
import kotlin.collections.ArrayList


class QuotesAdapter(private val quoteList: ArrayList<Quote>) : RecyclerView.Adapter<QuotesAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val author: TextView
        val content: TextView
        val rootView: View
        private  val TAG = "QuotesAdapter"
        init {
            author = itemView.findViewById(R.id.author)
            content = itemView.findViewById(R.id.content)
            rootView = itemView.findViewById(R.id.quote_container)
            val startColor = arrayOf("#2193b0", "#cc2b5e", "#eb3349", "#56ab2f", "#eecda3", "#02aab0", "#7b4397")
            val endColor = arrayOf("#6dd5ed", "#cc2b5e", "#f45c43", "#a8e063", "#ef629f", "#00cdac", "#dc2430")

            val spacing = itemView.resources.getDimensionPixelSize(R.dimen._10sdp)
            val pos = getRandomColorPosition(startColor)
            Log.d(TAG, "position: $pos")

            val gd = GradientDrawable(
                GradientDrawable.Orientation.TOP_BOTTOM, intArrayOf(Color.parseColor(startColor[pos]), Color.parseColor(endColor[pos]))
            )

            gd.cornerRadius = spacing.toFloat()

            rootView.background = gd



        }

        fun getRandomColorPosition(colors: Array<String>): Int {
            val rnd = Random()
            return rnd.nextInt(colors.size)
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

        holder.itemView.setOnClickListener(View.OnClickListener {
            val action = QuoteListFragmentDirections.actionQuoteListFragmentToQuotationFragment(quote)
            it.findNavController().navigate(action)
        })
    }

    override fun getItemCount(): Int {
        return quoteList.size
    }


}