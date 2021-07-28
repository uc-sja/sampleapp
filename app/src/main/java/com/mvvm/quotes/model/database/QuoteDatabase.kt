package com.mvvm.quotes.model.database

import androidx.room.RoomDatabase
import com.mvvm.quotes.model.database.room.dao.QuoteDao

abstract class QuoteDatabase:RoomDatabase() {
    abstract fun quoteDao():QuoteDao

    companion object{
        private val INSTANCE: QuoteDatabase? = null
         fun getInstance(){

         }

    }
}