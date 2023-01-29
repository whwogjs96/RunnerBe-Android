package com.applemango.runnerbe.presentation.screen.fragment.map.write

import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.applemango.runnerbe.R
import com.applemango.runnerbe.databinding.FragmentRunningWriteBinding
import com.applemango.runnerbe.presentation.model.DateResultListener
import com.applemango.runnerbe.presentation.model.RunningTag
import com.applemango.runnerbe.presentation.model.TimeResultListener
import com.applemango.runnerbe.presentation.screen.dialog.dateselect.DateSelectData
import com.applemango.runnerbe.presentation.screen.dialog.dateselect.DateTimePickerDialog
import com.applemango.runnerbe.presentation.screen.dialog.timeselect.TimeSelectData
import com.applemango.runnerbe.presentation.screen.dialog.timeselect.TimeSelectPickerDialog
import com.applemango.runnerbe.presentation.screen.fragment.base.BaseFragment
import com.applemango.runnerbe.util.AddressUtil
import com.naver.maps.map.LocationTrackingMode
import com.naver.maps.map.NaverMap
import com.naver.maps.map.OnMapReadyCallback
import com.naver.maps.map.util.FusedLocationSource
import kotlinx.coroutines.launch
import java.util.*

class RunningWriteFragment :
    BaseFragment<FragmentRunningWriteBinding>(R.layout.fragment_running_write),
    OnMapReadyCallback, View.OnClickListener {

    var TAG = "Runnerbe"

    private val PERMISSION_REQUEST_CODE = 100
    private lateinit var mNaverMap: NaverMap
    private lateinit var locationSource: FusedLocationSource

    private val viewModel: RunningWriteViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel
        locationSource = FusedLocationSource(this, PERMISSION_REQUEST_CODE)
        binding.scrollView.requestDisallowInterceptTouchEvent(true)
        binding.mapView.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_MOVE -> {
                    binding.scrollView.requestDisallowInterceptTouchEvent(true)
                }
                MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                    binding.scrollView.requestDisallowInterceptTouchEvent(true)
                }
            }
            v.performClick()
            binding.mapView.onTouchEvent(event)
        }

        observeBind()
        binding.dateLayout.setOnClickListener(this)
        binding.timeLayout.setOnClickListener(this)
    }

    private fun observeBind() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.radioChecked.collect {
                val tag = when(it) {
                    R.id.afterTab -> RunningTag.After
                    R.id.holidayTab -> RunningTag.Holiday
                    else -> RunningTag.Before
                }
                viewModel.runningDisplayDate.emit(DateSelectData.runningTagDefault(tag))
            }
        }
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
        binding.topTxt.text = AddressUtil.getAddress(
            requireContext(),
            mNaverMap.cameraPosition.target.latitude,
            mNaverMap.cameraPosition.target.longitude
        )
        //위치가 바뀔 때마다 주소 업데이트
        mNaverMap.addOnLocationChangeListener { location ->
            binding.topTxt.run {
                context?.let {
                    text = AddressUtil.getAddress(it, location.latitude, location.longitude)
                }
            }
        }
    }

    override fun onClick(v: View?) {
        when (v) {
            binding.dateLayout -> {
                DateTimePickerDialog.createShow(
                    requireContext(),
                    displayDate = viewModel.runningDisplayDate.value,
                    resultListener = object : DateResultListener {
                        override fun getDate(date: Date, displayDate: DateSelectData) {
                            viewModel.runningDate = date
                            viewModel.runningDisplayDate.value = displayDate
                        }
                    })
            }
            binding.timeLayout -> {
                TimeSelectPickerDialog.createShow(
                    requireContext(),
                    selectedData = viewModel.runningDisplayTime.value,
                    resultListener = object  : TimeResultListener {
                        override fun getDate(displayTime: TimeSelectData) {
                            viewModel.runningDisplayTime.value = displayTime
                        }
                    }
                )
            }
        }
    }

}