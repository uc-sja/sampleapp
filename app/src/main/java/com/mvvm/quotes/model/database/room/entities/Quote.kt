package com.mvvm.quotes.model.database.room.entities

import android.icu.util.LocaleData
import android.os.Parcelable
import androidx.room.Entity
import kotlinx.android.parcel.Parcelize
import java.text.SimpleDateFormat
import java.util.*

val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
val currentDate: String = sdf.format(Date())

@Entity(tableName="quotes")
@Parcelize
data class Quote(val quote: String, val author: String, val addDate: String = currentDate, val updateDate: String = currentDate) : Parcelable{
}
