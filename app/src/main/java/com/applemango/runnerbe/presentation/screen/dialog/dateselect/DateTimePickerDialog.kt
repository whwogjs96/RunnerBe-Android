package com.applemango.runnerbe.presentation.screen.dialog.dateselect

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.applemango.runnerbe.R
import com.applemango.runnerbe.databinding.DialogDateSelectBinding
import com.applemango.runnerbe.presentation.model.DateResultListener
import com.applemango.runnerbe.util.NumberUtil
import com.applemango.runnerbe.util.TimeUtil
import com.applemango.runnerbe.util.getDateList
import com.applemango.runnerbe.util.getYearList
import java.text.SimpleDateFormat
import java.util.*

class DateTimePickerDialog(context: Context) : Dialog(context, R.style.confirmDialogStyle) {

    val binding: DialogDateSelectBinding by lazy {
        DataBindingUtil.inflate(
            layoutInflater,
            R.layout.dialog_date_select,
            null,
            false
        )
    }

    var isAm = true
    var currentDate: DateSelectData? = null
    lateinit var result: DateResultListener
    private val yearList = getYearList(DEFAULT_DATE_SIZE)

    companion object {

        const val DEFAULT_DATE_SIZE = 7
        fun createShow(
            context: Context,
            isAm: Boolean = true,
            displayDate: DateSelectData? = null,
            resultListener: DateResultListener
        ) {
            val dialog = DateTimePickerDialog(context)
            with(dialog) {
                this.isAm = isAm
                this.currentDate = displayDate
                this.isAm = displayDate?.AMAndPM == "AM"
                this.result = resultListener
                show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val hourList = NumberUtil.getRange(0, 12)
        val minuteList = NumberUtil.getUnitNumber(0, 55, 5) //55분까지만 보이기
        binding.dateWheelView.setData(
            getDateList(DEFAULT_DATE_SIZE),
            getDateList(DEFAULT_DATE_SIZE).indexOf(currentDate?.formatDate)
        )
        binding.AMAndPMWheelView.setData(listOf("AM", "PM"), if (isAm) 0 else 1)
        binding.hourWheelView.setData(hourList, hourList.indexOf(currentDate?.hour))
        binding.minuteWheelView.setData(minuteList, minuteList.indexOf(currentDate?.minute))
        setContentView(binding.root)
        binding.confirmButton.setOnClickListener {
            changeDisplayToDate()?.let { completeDate ->
                result.getDate(
                    completeDate, DateSelectData(
                        formatDate = getDate(),
                        AMAndPM = getAm(),
                        hour = getHour(),
                        minute = getMinute()
                    )
                )
            }
            dismiss()
        }
    }

    private fun getDate(): String = binding.dateWheelView.getCurrentItem()
    private fun getAm(): String = binding.AMAndPMWheelView.getCurrentItem()
    private fun getHour(): String = binding.hourWheelView.getCurrentItem()
    private fun getMinute(): String = binding.minuteWheelView.getCurrentItem()

    private fun changeDisplayToDate(): Date? {
        val dateSplit = getDate().split("/")
        val hour = TimeUtil.getAMAndPMTo24(
            binding.AMAndPMWheelView.getCurrentItem<String>() == "AM",
            binding.hourWheelView.getCurrentItem<String>().toInt()
        )
        val date = "${yearList[binding.dateWheelView.currentPosition]}-${dateSplit[0]}-${
            dateSplit[1].split(" ")[0]
        } $hour:${binding.minuteWheelView.getCurrentItem<String>()}:00"
        return SimpleDateFormat("yyyy-MM-dd kk:mm:ss").parse(date)
    }
}