package com.applemango.runnerbe.screen.activity

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.applemango.runnerbe.R
import com.applemango.runnerbe.databinding.ActivityHomeBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * 로그인 이후에 사용되는 화면이 이 액티비티 내부에 작성합니다.
 */
@AndroidEntryPoint
class HomeActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityHomeBinding>(this, R.layout.activity_home)
        Log.e("여긴 오겠지", "HomeActivity")
    }
}