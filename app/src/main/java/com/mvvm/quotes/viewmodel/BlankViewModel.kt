package com.mvvm.quotes.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mvvm.quotes.model.Quote
import java.io.BufferedReader
import java.io.File
import java.lang.reflect.Type

class BlankViewModel(private val context: Context) : ViewModel() {

    private lateinit var quotesList: ArrayList<Quote>
    private var index = 0
    init {
        quotesList = getQuotes();
    }

    fun getQuote(): Quote{

        return quotesList[index]
    }

    fun nextQuote(): Quote{
        index++
        index = if (index < quotesList.size) index else 0
        Log.d(TAG, "nextQuote: "+index)
        return quotesList[index]
    }

    fun previousQuote(): Quote{
        index--
        index = if (index >= 0) index else quotesList.size -1
        Log.d(TAG, "nextQuote: "+index)
        return quotesList[index]
    }

    private val TAG = "BlankViewModel"

        private fun getQuotes() : ArrayList<Quote> {
                //Read quotes.json file

            val inputStream = context.assets.open("quotes.json");
            val size = inputStream.available();
            val buffer = ByteArray(size);
            inputStream.read(buffer)
            inputStream.close()
            val json = String(buffer, Charsets.UTF_8);

            val quoteType = object : TypeToken<ArrayList<Quote>>() {}.type

            val quotes : ArrayList<Quote> = Gson().fromJson<ArrayList<Quote>>(json, quoteType )


//            val quotesList = Gson().fromJson(json, Array<Quote>::class.java)

                for(q in quotes){
                    Log.d(TAG, "getQuotesArray: "+q.author)
                }

                return quotes
         }

}