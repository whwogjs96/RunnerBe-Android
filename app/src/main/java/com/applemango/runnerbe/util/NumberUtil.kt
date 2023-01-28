package com.applemango.runnerbe.util

object NumberUtil {

    //시작부터 끝까지 step 5 단위로 값을 가지는 리스트 생성
    fun getFiveUnitNumber(start : Int, end: Int) : List<String> =
        (start..end step 5).map { if(it in 0..9) "0$it" else it.toString()}

    fun getRange(start: Int, end: Int) : List<String> =
        IntRange(start, end).map { it.toString() }
}