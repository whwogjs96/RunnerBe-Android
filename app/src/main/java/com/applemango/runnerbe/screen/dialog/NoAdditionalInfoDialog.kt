package com.applemango.runnerbe.screen.dialog

import android.os.Bundle
import android.view.View
import com.applemango.runnerbe.R
import com.applemango.runnerbe.databinding.DialogNoAdditionalInfoBinding
import com.applemango.runnerbe.model.CachingObject

class NoAdditionalInfoDialog(): CustomBottomSheetDialog<DialogNoAdditionalInfoBinding>(R.layout.dialog_no_additional_info), View.OnClickListener{

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.noButton.setOnClickListener(this)
        binding.infoInputButton.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view) {
            binding.noButton -> {
                CachingObject.isColdStart = false
                dismiss()
            }
            binding.infoInputButton -> {
                //TODO
                //여기에 화면 이동 작업!
                dismiss()
            }
        }
    }

}