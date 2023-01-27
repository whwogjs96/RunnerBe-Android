package com.applemango.runnerbe.presentation.screen.dialog

import android.os.Bundle
import android.view.View
import com.applemango.runnerbe.R
import com.applemango.runnerbe.databinding.DialogNoAdditionalInfoBinding
import com.applemango.runnerbe.presentation.model.CachingObject

class NoAdditionalInfoDialog: CustomBottomSheetDialog<DialogNoAdditionalInfoBinding>(R.layout.dialog_no_additional_info){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.noButton.setOnClickListener{
            CachingObject.isColdStart = false
            dismiss()
        }
        binding.infoInputButton.setOnClickListener{
            //TODO
            //여기에 화면 이동 작업!
            dismiss()
        }
    }


}