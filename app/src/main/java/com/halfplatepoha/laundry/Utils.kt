package com.halfplatepoha.laundry

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class Utils {

    companion object {

        val ddmmmyyyyFormater: DateFormat = SimpleDateFormat("dd MMM yyyy")

        fun dateString(timestamp: Long): String {
            return ddmmmyyyyFormater.format(Date(timestamp))
        }
    }

}