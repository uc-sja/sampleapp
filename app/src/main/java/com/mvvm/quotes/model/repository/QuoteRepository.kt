package com.mvvm.quotes.model.repository

import androidx.lifecycle.LiveData
import com.mvvm.quotes.model.database.room.dao.QuoteDao
import com.mvvm.quotes.model.database.room.entities.Quote

class QuoteRepository(private val quoteDao: QuoteDao) {
    fun insertQuote(quote:Quote){

        //Here we can implement data fetching logic
        //like from where to fetch data offline or from server
        quoteDao.insertQuote(quote)
    }

    fun fetchQuotes(): LiveData<ArrayList<Quote>>{
       return quoteDao.fetchQuotes()
    }
}