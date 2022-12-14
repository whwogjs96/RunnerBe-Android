package com.applemango.runnerbe.screen.fragment

import android.location.Address
import android.location.Geocoder
import android.os.Bundle
import android.util.Log
import android.view.View
import com.applemango.runnerbe.R
import com.applemango.runnerbe.RunnerBeApplication
import com.applemango.runnerbe.databinding.FragmentRunnerMapBinding
import com.applemango.runnerbe.model.CachingObject
import com.applemango.runnerbe.screen.activity.HomeActivity
import com.applemango.runnerbe.screen.dialog.NoAdditionalInfoDialog
import com.applemango.runnerbe.screen.fragment.base.BaseFragment
import com.naver.maps.map.LocationTrackingMode
import com.naver.maps.map.NaverMap
import com.naver.maps.map.OnMapReadyCallback
import com.naver.maps.map.util.FusedLocationSource
import dagger.hilt.android.AndroidEntryPoint
import java.io.IOException
import java.util.*
import kotlin.collections.ArrayList

@AndroidEntryPoint
class RunnerMapFragment : BaseFragment<FragmentRunnerMapBinding>(R.layout.fragment_runner_map),
    OnMapReadyCallback {
    var TAG = "Runnerbe"
    var userId = -1
    private val PERMISSION_REQUEST_CODE = 100
    private lateinit var mNaverMap: NaverMap
    private lateinit var locationSource: FusedLocationSource

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.mapView.getMapAsync(this)
        locationSource = FusedLocationSource(this, PERMISSION_REQUEST_CODE)
        checkAdditionalUserInfo()
    }

    private fun checkAdditionalUserInfo() {
        if(RunnerBeApplication.mTokenPreference.getUserId() == 0 && CachingObject.isColdStart) {
            showAdditionalInfoDialog()
        }
    }

    private fun showAdditionalInfoDialog() {
        val prev = parentFragmentManager.findFragmentByTag(TAG)
        if (prev != null) {
            parentFragmentManager.also { it.beginTransaction().remove(prev).commit() }
        }
        NoAdditionalInfoDialog().show(childFragmentManager, TAG)
    }
    override fun onStart() {
        super.onStart()
        binding.mapView.onStart()
    }

    override fun onResume() {
        super.onResume()
        binding.mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        binding.mapView.onPause()
    }

    override fun onStop() {
        super.onStop()
        binding.mapView.onStop()
    }


    override fun onLowMemory() {
        super.onLowMemory()
        binding.mapView.onLowMemory()
    }


    override fun onMapReady(map: NaverMap) {
        Log.i(TAG, "onMapReady")
        mNaverMap = map
        mNaverMap.locationSource = locationSource
        mNaverMap.locationTrackingMode = LocationTrackingMode.Follow

        //현재위치로 주소 디폴트 셋팅
        binding.topTxt.text = getAddress(
            mNaverMap.cameraPosition.target.latitude,
            mNaverMap.cameraPosition.target.longitude
        )
        //위치가 바뀔 때마다 주소 업데이트
        mNaverMap.addOnLocationChangeListener { location ->
            binding.topTxt.run {
                text = getAddress(location.latitude, location.longitude)
            }
        }
    }

    // 좌표 -> 주소 변환
    private fun getAddress(lat: Double, lng: Double): String {
        val geoCoder = Geocoder(requireContext(), Locale.KOREA)
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