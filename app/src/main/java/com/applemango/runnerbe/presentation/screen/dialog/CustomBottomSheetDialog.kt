package com.applemango.runnerbe.presentation.screen.dialog

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

abstract class CustomBottomSheetDialog<T : ViewDataBinding>(@LayoutRes private val layoutId: Int) : BottomSheetDialogFragment(){

    private var _binding: T? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(
            layoutInflater,
            layoutId,
            null,
            false
        )
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val sheetDialog = super.onCreateDialog(savedInstanceState)
        sheetDialog.setOnShowListener {
            val bottomSheet = sheetDialog.findViewById<FrameLayout>(com.google.android.material.R.id.design_bottom_sheet)
            val params = bottomSheet.layoutParams
            bottomSheet.setBackgroundResource(android.R.color.transparent)
//            params.height = getScreenHeight()
            bottomSheet.layoutParams = params
            BottomSheetBehavior.from(bottomSheet).state = BottomSheetBehavior.STATE_EXPANDED
            BottomSheetBehavior.from(bottomSheet).isDraggable = true
        }
        return sheetDialog
    }

//    private fun getScreenHeight(): Int {
//        return Resources.getSystem().displayMetrics.heightPixels * 90 / 100
//    }

}