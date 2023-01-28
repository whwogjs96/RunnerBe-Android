package com.applemango.runnerbe.presentation.screen.dialog.dateselect

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.applemango.runnerbe.R
import com.applemango.runnerbe.databinding.DialogDateSelectBinding
import com.applemango.runnerbe.util.NumberUtil

class DateTimePickerDialog(context: Context) : Dialog(context, R.style.confirmDialogStyle) {

    val binding : DialogDateSelectBinding by lazy {
        DataBindingUtil.inflate(
            layoutInflater,
            R.layout.dialog_date_select,
            null,
            false
        )
    }

    var currentHour = 0
    var currentMinute = 0

    companion object {
        fun createShow(context: Context) {
            val dialog = DateTimePickerDialog(context)
            with(dialog) {
                show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.dateWheelView.setData(listOf("3/27(일)","3/28(월)", "3/29(화)", "3/30(수)", "3/31(목)", "4/1(금)"), 0)
        binding.AMAndPMWheelView.setData(listOf("AM","PM"), 0)
        binding.hourWheelView.setData(NumberUtil.getRange(0, 12), currentHour)
        binding.minuteWheelView.setData(NumberUtil.getFiveUnitNumber(0, 60) ,currentMinute)
        setContentView(binding.root)
    }

}