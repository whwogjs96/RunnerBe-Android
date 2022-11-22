package com.applemango.runnerbe.screen.dialog

import android.os.Bundle
import android.view.View
import com.applemango.runnerbe.R
import com.applemango.runnerbe.databinding.DialogNoAdditionalInfoBinding

class NoAdditionalInfoDialog(): CustomBottomSheetDialog<DialogNoAdditionalInfoBinding>(R.layout.dialog_no_additional_info), View.OnClickListener{

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.noButton
    }

    override fun onClick(view: View?) {
        when(view) {
            binding.noButton -> dismiss()
            binding.infoInputButton -> {
                //TODO
                //여기에 화면 이동 작업!
                dismiss()
            }
        }
    }

}