package me.johnyoat.hellocast.ext

import java.text.DateFormat
import java.util.*

fun Long.toDateString(dateFormat: Int =  DateFormat.MEDIUM): String {
    val df = DateFormat.getDateInstance(dateFormat, Locale.getDefault())
    return df.format(this)
}