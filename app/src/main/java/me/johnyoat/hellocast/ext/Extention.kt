package me.johnyoat.hellocast.ext

import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import me.johnyoat.hellocast.R
import java.text.DateFormat
import java.util.*

fun Long.toDateString(dateFormat: Int =  DateFormat.MEDIUM): String {
    val df = DateFormat.getDateInstance(dateFormat, Locale.getDefault())
    return df.format(this)
}


fun Fragment.popBackStack(){
    this.requireActivity().findNavController(R.id.fragmentHost).popBackStack()
}

fun Int.toDuration(): String {
    val h = this / 3600
    val m = this % 3600 / 60
    val s = this % 60
    val sh = if (h > 0) "${h}h" else ""
    val sm = (if (m in 1..9 && h > 0) "0" else "") + if (m > 0) if (h > 0 && s == 0) m.toString() else "${m}min" else ""
    return sh + (if (h > 0) " " else "") + sm + (if (m > 0) " " else "")
}