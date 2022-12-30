package com.applemango.runnerbe.util

import java.text.SimpleDateFormat
import java.util.*

/**
 * author : 두루
 */

fun TimeHourAndMinute(dateString: String): String {
    val stringToDate = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val to: Date = stringToDate.parse(dateString)
    val dateToString = SimpleDateFormat("HH:mm")
    return dateToString.format(to)
}

fun TimeHourAndMinuteAndSecond(dateString: String): String {
    val stringToDate = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val to: Date = stringToDate.parse(dateString)
    val dateToString = SimpleDateFormat("HH:mm:ss")
    return dateToString.format(to)
}

fun DateString(dateString: String): String {
    val stringToDate = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val to: Date = stringToDate.parse(dateString)
    val dateToString = SimpleDateFormat("yyyy-MM-dd")
    return dateToString.format(to)
}

fun TimeString(dateString: String): String {
    val res = dateString.split(":")
    return res[0]+"시"+res[1]+"분"
}

fun BeforeTimeString(dateString: String): String {
    val stringToDate = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val date = stringToDate.parse(dateString)

    val today = Calendar.getInstance()
    val day = (today.time.time-date.time) / (60*60*24*1000)
    val hour = (today.time.time-date.time) / (60*60*1000)
    val minute = (today.time.time-date.time) / (60*1000)
    return if(day > 0) {
        day.toString()+"일 전"
    }
    else if(hour > 0) {
        hour.toString()+"시간 전"
    }
    else {
        minute.toString()+"분 전"
    }
}

fun removeLastNchars(str: String, n: Int): String {
    return if (str == "" || str.length < n) {
        str
    } else str.substring(0, str.length - n)
}