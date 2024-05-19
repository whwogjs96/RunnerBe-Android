package com.applemango.runnerbe.presentation.screen.fragment.chat.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.applemango.runnerbe.R
import com.applemango.runnerbe.databinding.ItemMeImageTalkBinding
import com.applemango.runnerbe.databinding.ItemMeMessageTalkBinding
import com.applemango.runnerbe.databinding.ItemMyTalkContainerBinding
import com.applemango.runnerbe.databinding.ItemOtherImageTalkBinding
import com.applemango.runnerbe.databinding.ItemOtherMessageTalkBinding
import com.applemango.runnerbe.databinding.ItemOtherTalkContainerBinding
import com.applemango.runnerbe.presentation.screen.fragment.chat.detail.uistate.RunningTalkItem
import com.applemango.runnerbe.presentation.screen.fragment.chat.detail.uistate.RunningTalkUiState
import com.applemango.runnerbe.util.dpToPx
import com.applemango.runnerbe.util.glide.GranularRoundedAndBorderTransform
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners
import com.bumptech.glide.request.RequestOptions

class RunningTalkDetailListAdapter :
    ListAdapter<RunningTalkUiState, RecyclerView.ViewHolder>(RunningTalkDetailDiffCallBack()) {

    private val myViewType = 1
    private val otherViewType = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            myViewType -> {
                RunningTalkDetailMyContainerViewHolder(
                    ItemMyTalkContainerBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }

            else -> {
                RunningTalkDetailOtherContainerViewHolder(
                    ItemOtherTalkContainerBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is RunningTalkDetailMyContainerViewHolder -> {
                holder.bind(item = getItem(position) as RunningTalkUiState.MyRunningTalkUiState)
            }

            is RunningTalkDetailOtherContainerViewHolder -> {
                holder.bind(item = getItem(position) as RunningTalkUiState.OtherRunningTalkUiState)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is RunningTalkUiState.MyRunningTalkUiState -> myViewType
            is RunningTalkUiState.OtherRunningTalkUiState -> otherViewType
        }
    }
}

class RunningTalkDetailMyContainerViewHolder(val binding: ItemMyTalkContainerBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: RunningTalkUiState.MyRunningTalkUiState) {
        val context = binding.root.context
        binding.messageContainerView.removeAllViews()
        item.items.forEach {
            val itemBinding = when (it) {
                is RunningTalkItem.MessageTalkItem -> {
                    val itemUi =
                        ItemMeMessageTalkBinding.inflate(LayoutInflater.from(context))
                    itemUi.apply {
                        messageView.text = it.message
                        messageView.setTextColor(
                            ResourcesCompat.getColor(
                                context.resources,
                                if (item.isPostWriter) R.color.black
                                else R.color.dark_g1,
                                null
                            )
                        )
                        messageView.background = ResourcesCompat.getDrawable(
                            context.resources,
                            if (item.isPostWriter) R.drawable.bg_my_talk_organizer
                            else R.drawable.bg_my_talk_participants,
                            null
                        )
                        if (item.items.last() == it) createDateView.text = item.createTime
                    }
                    itemUi
                }

                is RunningTalkItem.ImageTalkItem -> {
                    val itemUi =
                        ItemMeImageTalkBinding.inflate(LayoutInflater.from(context))
                    Glide.with(itemUi.talkImageView)
                        .load(it.imgUrl)
                        .apply(
                            RequestOptions()
                                .override(200.dpToPx(context), 200.dpToPx(context))
                                .transform(
                                    CenterCrop(),
                                    GranularRoundedAndBorderTransform(
                                        12f,
                                        12f,
                                        12f,
                                        0f,
                                        1f,
                                        R.color.white_20
                                    )
                                )
                        )
                        .into(itemUi.talkImageView)
                    itemUi.apply {
                        if (item.items.last() == it) {
                            createDateView.text = item.createTime
                            createDateView.visibility = View.VISIBLE
                        } else {
                            createDateView.visibility = View.GONE
                        }
                    }
                    itemUi
                }
            }
            binding.messageContainerView.addView(itemBinding.root)
            val layoutParams = itemBinding.root.layoutParams
            layoutParams.width = ViewGroup.LayoutParams.WRAP_CONTENT
            layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT
            if (item.items.last() != it) {
                if (layoutParams is LinearLayoutCompat.LayoutParams) {
                    layoutParams.setMargins(0, 0, 0, 10.dpToPx(context))
                    itemBinding.root.layoutParams = layoutParams
                }
            }
        }
    }
}

class RunningTalkDetailOtherContainerViewHolder(val binding: ItemOtherTalkContainerBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: RunningTalkUiState.OtherRunningTalkUiState) {
        val context = binding.root.context
        binding.messageContainerView.removeAllViews()
        item.items.forEach {
            val itemBinding = when (it) {
                is RunningTalkItem.MessageTalkItem -> {
                    val itemUi =
                        ItemOtherMessageTalkBinding.inflate(LayoutInflater.from(context))
                    itemUi.apply {
                        if (item.items.first() == it && item.isReportMode) {
                            reportCheckBtn.visibility = View.VISIBLE
                        } else {
                            reportCheckBtn.visibility = View.GONE
                        }
                        messageView.text = it.message
                        messageView.setTextColor(
                            ResourcesCompat.getColor(
                                context.resources,
                                if (item.isPostWriter) R.color.black
                                else R.color.dark_g1,
                                null
                            )
                        )
                        messageView.background = ResourcesCompat.getDrawable(
                            context.resources,
                            if (item.isPostWriter) R.drawable.bg_other_talk_organizer
                            else R.drawable.bg_other_talk_participants,
                            null
                        )
                        if (item.items.last() == it) {
                            createDateView.text = item.createTime
                            createDateView.visibility = View.VISIBLE
                        } else {
                            createDateView.visibility = View.GONE
                        }
                    }
                    itemUi
                }

                is RunningTalkItem.ImageTalkItem -> {
                    val itemUi =
                        ItemOtherImageTalkBinding.inflate(LayoutInflater.from(context))
                    Glide.with(itemUi.talkImageView)
                        .load(it.imgUrl)
                        .apply(
                            RequestOptions()
                                .override(200.dpToPx(context), 200.dpToPx(context))
                                .transform(
                                    CenterCrop(),
                                    GranularRoundedAndBorderTransform(
                                        12f,
                                        12f,
                                        0f,
                                        12f,
                                        1f,
                                        R.color.white_20
                                    )
                                )
                        )
                        .into(itemUi.talkImageView)
                    itemUi.apply {
                        if (item.items.last() == it) {
                            createDateView.text = item.createTime
                            createDateView.visibility = View.VISIBLE
                        } else {
                            createDateView.visibility = View.GONE
                        }
                    }
                    itemUi
                }
            }
            binding.messageContainerView.addView(itemBinding.root)
        }
    }
}

class RunningTalkDetailDiffCallBack : DiffUtil.ItemCallback<RunningTalkUiState>() {
    override fun areItemsTheSame(
        oldItem: RunningTalkUiState,
        newItem: RunningTalkUiState
    ): Boolean = oldItem == newItem


    override fun areContentsTheSame(
        oldItem: RunningTalkUiState,
        newItem: RunningTalkUiState
    ): Boolean {
        return when (oldItem) {
            is RunningTalkUiState.MyRunningTalkUiState -> {
                if (newItem is RunningTalkUiState.MyRunningTalkUiState) {
                    oldItem == newItem
                } else false
            }

            is RunningTalkUiState.OtherRunningTalkUiState -> {
                if (newItem is RunningTalkUiState.OtherRunningTalkUiState) {
                    oldItem == newItem
                } else false
            }
        }
    }

}