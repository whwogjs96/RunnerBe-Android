package com.applemango.runnerbe.util

import android.content.Context
import android.location.Address
import android.location.Geocoder
import java.io.IOException
import java.util.*
import kotlin.collections.ArrayList

object AddressUtil {
    // 좌표 -> 주소 변환
    fun getAddress(context : Context, lat: Double, lng: Double): String {
        val geoCoder = Geocoder(context, Locale.KOREA)
        val address: ArrayList<Address>
        var addressResult = "검색되지 않는 지역이에요."
        try {
            //세번째 파라미터는 좌표에 대해 주소를 리턴 받는 갯수로
            //한좌표에 대해 두개이상의 이름이 존재할수있기에 주소배열을 리턴받기 위해 최대갯수 설정
            address = geoCoder.getFromLocation(lat, lng, 1) as ArrayList<Address>
            if (address.size > 0) {
                // 주소 받아오기 (-시 -구)
                val currentLocationAddress = "${address[0].locality} ${address[0].subLocality}"
                addressResult = currentLocationAddress
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return addressResult
    }
}