package com.applemango.runnerbe.screen.fragment.mypage.mypost

import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.applemango.runnerbe.databinding.ItemPostBinding
import com.applemango.runnerbe.dto.Posting

class MyPostViewHolder(val binding : ItemPostBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Posting) {
        binding.holderModel = item
    }
}