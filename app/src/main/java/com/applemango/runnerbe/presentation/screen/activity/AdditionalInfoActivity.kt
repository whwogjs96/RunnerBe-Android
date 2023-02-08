package com.applemango.runnerbe.presentation.screen.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.applemango.runnerbe.R
import com.applemango.runnerbe.databinding.ActivityAdditionalInfoBinding

class AdditionalInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityAdditionalInfoBinding>(this, R.layout.activity_additional_info)
    }
}