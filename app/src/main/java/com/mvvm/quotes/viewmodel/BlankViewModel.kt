package com.mvvm.quotes.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mvvm.quotes.model.database.room.entities.Quote
import com.mvvm.quotes.model.pojo.Quote

class BlankViewModel(private val context: Context) : ViewModel() {

    private lateinit var quotesList: ArrayList<Quote>
    private var index = 0
    val quote = MutableLiveData(Quote("", ""))

    init {
        quotesList = getQuotes();
        quote.value = quotesList[index]
    }
//
//    fun getQuote(): Quote{
//        return quotesList[index]
//    }

    fun nextQuote() {
        index++
        index = if (index < quotesList.size) index else 0
        Log.d(TAG, "nextQuote: "+index)

        quote.value = quotesList[index]
    }

    fun previousQuote() {
        index--
        index = if (index >= 0) index else quotesList.size -1
        Log.d(TAG, "nextQuote: "+index)

        quote.value = quotesList[index]

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