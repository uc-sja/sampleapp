package com.mvvm.quotes.model.database.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.mvvm.quotes.model.database.room.entities.Quote

@Dao
interface QuoteDao {
    @Insert
    fun insertQuote(quote: Quote)

    @Query("SELECT * FROM QUOTES")
    fun fetchQuotes(): LiveData<ArrayList<Quote>>
}