package com.applemango.runnerbe.screen.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window

class LoadingDialog constructor(context: Context) : Dialog(context){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(com.applemango.runnerbe.R.layout.dialog_loading)
        setCanceledOnTouchOutside(false)
        setCancelable(false)
        window!!.setBackgroundDrawable(ColorDrawable())
        window!!.setDimAmount(0.2f)
    }

    override fun show() {
        if(!this.isShowing) super.show()
    }
}