package com.applemango.runnerbe.presentation.screen.fragment.map.write

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import com.applemango.runnerbe.R
import com.applemango.runnerbe.databinding.FragmentRunningWriteTwoBinding
import com.applemango.runnerbe.presentation.screen.fragment.base.BaseFragment
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.NaverMap
import com.naver.maps.map.OnMapReadyCallback
import com.naver.maps.map.overlay.Marker
import com.naver.maps.map.overlay.OverlayImage
import dagger.hilt.android.AndroidEntryPoint

/**
 * @author niaka
 *
 */
@AndroidEntryPoint
class RunningWriteTwoFragment :
    BaseFragment<FragmentRunningWriteTwoBinding>(R.layout.fragment_running_write_two),
    OnMapReadyCallback, View.OnClickListener {

    private lateinit var mNaverMap: NaverMap
    private var centerMarker : Marker? = null

    private val viewModel: RunningWriteTwoViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.mapView.getMapAsync(this)

        binding.backBtn.setOnClickListener(this)
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
        Log.e("TAG", map.toString())
        mNaverMap = map
        mNaverMap.uiSettings.isScrollGesturesEnabled = false
        mNaverMap.uiSettings.isZoomControlEnabled = false
        createCenterMarker()
    }

    private fun createCenterMarker() {
        centerMarker = Marker()
        centerMarker?.apply {
            position = LatLng(
                mNaverMap.cameraPosition.target.latitude,
                mNaverMap.cameraPosition.target.longitude
            )
            map = mNaverMap
            icon = OverlayImage.fromResource(R.drawable.ic_select_map_marker)
        }

    }

    override fun onClick(v: View?) {
        when(v) {
            binding.backBtn -> navPopStack()
        }
    }


}