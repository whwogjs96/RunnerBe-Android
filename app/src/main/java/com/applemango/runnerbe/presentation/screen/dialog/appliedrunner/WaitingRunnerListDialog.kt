package com.applemango.runnerbe.presentation.screen.dialog.appliedrunner

import android.app.Activity
import android.app.Dialog
import android.content.res.Resources
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.widget.FrameLayout
import androidx.databinding.ObservableArrayList
import androidx.fragment.app.viewModels
import com.applemango.runnerbe.R
import com.applemango.runnerbe.data.dto.UserInfo
import com.applemango.runnerbe.databinding.DialogWaitingRunnuerListBinding
import com.applemango.runnerbe.presentation.screen.dialog.CustomBottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetBehavior


class WaitingRunnerListDialog(
    private val waitingList: ObservableArrayList<UserInfo>
) : CustomBottomSheetDialog<DialogWaitingRunnuerListBinding>(R.layout.dialog_waiting_runnuer_list) {

    private val viewModel: WaitingRunnerViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel
        viewModel.waitingInfo.addAll(waitingList)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val sheetDialog = super.onCreateDialog(savedInstanceState)
        sheetDialog.setOnShowListener {
            val bottomSheet =
                sheetDialog.findViewById<FrameLayout>(com.google.android.material.R.id.design_bottom_sheet)
            val params = bottomSheet.layoutParams
            bottomSheet.setBackgroundResource(android.R.color.transparent)
            params.height = getScreenHeight()
            bottomSheet.layoutParams = params
            BottomSheetBehavior.from(bottomSheet).state = BottomSheetBehavior.STATE_EXPANDED
            BottomSheetBehavior.from(bottomSheet).isDraggable = true
        }
        return sheetDialog
    }

    private fun getScreenHeight(): Int {
        return Resources.getSystem().displayMetrics.heightPixels
    }
}