package com.applemango.runnerbe.presentation.screen.fragment.chat.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.applemango.runnerbe.R
import com.applemango.runnerbe.databinding.ItemImageTalkBinding
import com.applemango.runnerbe.databinding.ItemMessageTalkBinding
import com.applemango.runnerbe.databinding.ItemMyTalkContainerBinding
import com.applemango.runnerbe.databinding.ItemOtherTalkContainerBinding
import com.applemango.runnerbe.presentation.screen.fragment.chat.detail.uistate.RunningTalkItem
import com.applemango.runnerbe.presentation.screen.fragment.chat.detail.uistate.RunningTalkUiState
import com.applemango.runnerbe.util.getMonthAndDay

class RunningTalkDetailListAdapter :
    ListAdapter<RunningTalkUiState, RecyclerView.ViewHolder>(RunningTalkDetailDiffCallBack()) {

    private val myViewType = 1
    private val otherViewType = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            myViewType -> {
                RunningTalkDetailMyContainerViewHolder(
                    ItemMyTalkContainerBinding.inflate(LayoutInflater.from(parent.context))
                )
            }

            else -> {
                RunningTalkDetailOtherContainerViewHolder(
                    ItemOtherTalkContainerBinding.inflate(LayoutInflater.from(parent.context))
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
        //TODO 아이템 연결 작업
        val context = binding.root.context
        binding.createDateView.text = getMonthAndDay(item.createTime)
        binding.messageContainerView.removeAllViews()
        item.items.forEach {
            val itemBinding = when (it) {
                is RunningTalkItem.MessageTalkItem -> {
                    val itemUi =
                        ItemMessageTalkBinding.inflate(LayoutInflater.from(context))
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
                    }
                    itemUi
                }

                is RunningTalkItem.ImageTalkItem -> {
                    val itemUi =
                        ItemImageTalkBinding.inflate(LayoutInflater.from(context))
                    //TODO 이미지 작업
                    itemUi
                }
            }
            binding.messageContainerView.addView(itemBinding.root)
        }
    }
}

class RunningTalkDetailOtherContainerViewHolder(val binding: ItemOtherTalkContainerBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: RunningTalkUiState.OtherRunningTalkUiState) {
        val context = binding.root.context
        binding.createDateView.text = getMonthAndDay(item.createTime)
        binding.messageContainerView.removeAllViews()
        item.items.forEach {
            val itemBinding = when (it) {
                is RunningTalkItem.MessageTalkItem -> {
                    val itemUi =
                        ItemMessageTalkBinding.inflate(LayoutInflater.from(context))
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
                            if (item.isPostWriter) R.drawable.bg_other_talk_organizer
                            else R.drawable.bg_other_talk_participants,
                            null
                        )
                    }
                    itemUi
                }

                is RunningTalkItem.ImageTalkItem -> {
                    val itemUi =
                        ItemImageTalkBinding.inflate(LayoutInflater.from(context))
                    //TODO 이미지 작업
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