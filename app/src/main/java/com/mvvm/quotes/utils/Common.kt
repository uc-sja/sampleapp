package com.mvvm.quotes.utils

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object Common {
    fun formateDate(addDate: String?): String? {
        val format1 = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val format2 = SimpleDateFormat("EE, d MMM yyyy hh:mm a")
        var formattedDate = addDate
        var selectedDateTime: Date? = null
        try {
            selectedDateTime = format1.parse(addDate)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        formattedDate = format2.format(selectedDateTime)
        return formattedDate
    }

}