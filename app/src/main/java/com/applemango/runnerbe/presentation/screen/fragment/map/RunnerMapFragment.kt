package com.applemango.runnerbe.presentation.screen.fragment.map

import android.location.Address
import android.location.Geocoder
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import com.applemango.runnerbe.R
import com.applemango.runnerbe.RunnerBeApplication
import com.applemango.runnerbe.databinding.FragmentRunnerMapBinding
import com.applemango.runnerbe.presentation.model.CachingObject
import com.applemango.runnerbe.presentation.screen.dialog.NoAdditionalInfoDialog
import com.applemango.runnerbe.presentation.screen.fragment.MainFragmentDirections
import com.applemango.runnerbe.presentation.screen.fragment.base.BaseFragment
import com.applemango.runnerbe.util.AddressUtil
import com.applemango.runnerbe.util.setHeight
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

    private val viewModel : RunnerMapViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.addClick = writeClickEvent()
        binding.vm = viewModel
        binding.mapView.onCreate(savedInstanceState)
        binding.mapView.getMapAsync(this)
        locationSource = FusedLocationSource(this, PERMISSION_REQUEST_CODE)
        checkAdditionalUserInfo()
    }

    private fun checkAdditionalUserInfo() {
        if(RunnerBeApplication.mTokenPreference.getUserId() <= 0 && CachingObject.isColdStart) {
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

    override fun onDestroyView() {
        super.onDestroyView()
        binding.mapView.onDestroy()
    }


    override fun onMapReady(map: NaverMap) {
        Log.i(TAG, "onMapReady")
        mNaverMap = map
        mNaverMap.locationSource = locationSource
        mNaverMap.locationTrackingMode = LocationTrackingMode.Follow
        //SlidingUpPanelLayout이 크기를 자꾸 변경하는 문제가 있어서 레이아웃 사이즈를 초기에 고정시켜버리기
        binding.mapLayout.setHeight(binding.mapLayout.measuredHeight)
        //현재위치로 주소 디폴트 셋팅
        binding.topTxt.text = AddressUtil.getAddress(
            requireContext(),
            mNaverMap.cameraPosition.target.latitude,
            mNaverMap.cameraPosition.target.longitude
        )

        //위치가 바뀔 때마다 주소 업데이트
        mNaverMap.addOnLocationChangeListener { location ->
            binding.topTxt.run {
                text = AddressUtil.getAddress(requireContext(), location.latitude, location.longitude)
            }
        }
    }

    private fun writeClickEvent() = View.OnClickListener {
        navigate(MainFragmentDirections.actionMainFragmentToRunningWriteFragment())
    }
}