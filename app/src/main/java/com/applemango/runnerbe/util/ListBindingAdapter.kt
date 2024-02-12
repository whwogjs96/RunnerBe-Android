package com.applemango.runnerbe.util

import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.RecyclerView
import com.applemango.runnerbe.data.dto.Messages
import com.applemango.runnerbe.data.dto.Posting
import com.applemango.runnerbe.presentation.model.CreatorImageAndPosition
import com.applemango.runnerbe.data.dto.Room
import com.applemango.runnerbe.data.dto.UserInfo
import com.applemango.runnerbe.presentation.model.listener.*
import com.applemango.runnerbe.presentation.screen.dialog.appliedrunner.WaitingRunnerInfoAdapter
import com.applemango.runnerbe.presentation.screen.fragment.main.postdetail.RunnerInfoAdapter
import com.applemango.runnerbe.presentation.screen.dialog.selectitem.SelectListData
import com.applemango.runnerbe.presentation.screen.dialog.selectitem.SelectListItemAdapter
import com.applemango.runnerbe.presentation.screen.fragment.bookmark.BookMarkAdapter
import com.applemango.runnerbe.presentation.screen.fragment.chat.RunningTalkAdapter
import com.applemango.runnerbe.presentation.screen.fragment.chat.detail.RunningTalkDetailAdapter
import com.applemango.runnerbe.presentation.screen.fragment.map.HomePostAdapter
import com.applemango.runnerbe.presentation.screen.fragment.map.write.paceselect.PaceSimpleSelectListAdapter
import com.applemango.runnerbe.presentation.screen.fragment.mypage.joinpost.JoinPostAdapter
import com.applemango.runnerbe.presentation.screen.fragment.mypage.mypost.MyPostAdapter
import com.applemango.runnerbe.presentation.screen.fragment.mypage.mypost.accession.AttendanceAccessionAdapter
import com.applemango.runnerbe.presentation.screen.fragment.mypage.mypost.see.AttendanceSeeAdapter
import com.applemango.runnerbe.presentation.screen.fragment.mypage.paceinfo.PaceInfoListAdapter
import com.applemango.runnerbe.presentation.screen.fragment.mypage.paceinfo.PaceSelectItem
import com.applemango.runnerbe.presentation.screen.fragment.mypage.setting.creator.CreatorAdapter

@BindingAdapter("myPostAdapter", "myPostEvent")
fun setMyPostAdapter(
    recyclerView: RecyclerView,
    dataList: ObservableArrayList<Posting>,
    myPostClickListener: MyPostClickListener
) {
    if (recyclerView.adapter == null) {
        recyclerView.adapter = MyPostAdapter(dataList, myPostClickListener)
    }
    recyclerView.adapter?.notifyDataSetChanged()
}

@BindingAdapter("attendanceSeeAdapter")
fun setAttendanceSeeAdapter(
    recyclerView: RecyclerView,
    dataList: ObservableArrayList<UserInfo>
) {
    if (recyclerView.adapter == null) {
        recyclerView.adapter = AttendanceSeeAdapter(dataList)
    }
    recyclerView.adapter?.notifyDataSetChanged()
}

@BindingAdapter("attendanceAccessionAdapter", "attendanceAccessionClickListener")
fun setAttendanceAccessionAdapter(
    recyclerView: RecyclerView,
    dataList: ObservableArrayList<UserInfo>,
    accessionClickListener: AttendanceAccessionClickListener
) {
    if (recyclerView.adapter == null) {
        recyclerView.adapter = AttendanceAccessionAdapter(dataList, accessionClickListener)
    }
    recyclerView.adapter?.notifyDataSetChanged()
}

@BindingAdapter("joinPostAdapter")
fun setJoinPostAdapter(recyclerView: RecyclerView, dataList: ObservableArrayList<Posting>) {
    if (recyclerView.adapter == null) {
        recyclerView.adapter = JoinPostAdapter(dataList)
    }
    recyclerView.adapter?.notifyDataSetChanged()
}

@BindingAdapter("creatorAdapter")
fun setCreatorAdapter(recyclerView: RecyclerView, dataList: List<CreatorImageAndPosition>) {
    if (recyclerView.adapter == null) {
        recyclerView.adapter = CreatorAdapter(dataList)
    }
    recyclerView.adapter?.notifyDataSetChanged()
}

@BindingAdapter("runningTalkListAdapter", "runningTalkClickListener")
fun setRunningTalkListAdapter(
    recyclerView: RecyclerView,
    dataList: ObservableArrayList<Room>,
    roomClickListener: RoomClickListener
) {
    if (recyclerView.adapter == null) {
        recyclerView.adapter = RunningTalkAdapter(dataList, roomClickListener)
    }
    recyclerView.adapter?.notifyDataSetChanged()
}

@BindingAdapter("selectListAdapter")
fun setSelectListAdapter(
    recyclerView: RecyclerView,
    dataList: ObservableArrayList<SelectListData>
) {
    if (recyclerView.adapter == null) {
        recyclerView.adapter = SelectListItemAdapter(dataList)
    }
    recyclerView.adapter?.notifyDataSetChanged()
}

@BindingAdapter("postListAdapter", "bookmarkEvent")
fun setPostListAdapter(
    recyclerView: RecyclerView,
    dataList: ObservableArrayList<Posting>,
    bookMarkListener: BookMarkClickListener
) {
    if (recyclerView.adapter == null) {
        recyclerView.adapter = BookMarkAdapter(dataList, bookMarkListener)
    }
    recyclerView.adapter?.notifyDataSetChanged()
}

@BindingAdapter("bind:homePostAdapter", "bind:homeBookMarkListener")
fun setPostAdapter(
    recyclerView: RecyclerView,
    dataList: ObservableArrayList<Posting>,
    bookMarkListener: BookMarkClickListener
) {
    recyclerView.adapter?: run {
        recyclerView.adapter = HomePostAdapter(bookMarkListener)
    }
    val adapter = recyclerView.adapter
    recyclerView.itemAnimator = null
    if(adapter is HomePostAdapter) adapter.submitList(dataList)
}

@BindingAdapter("runnerInfoAdapter")
fun setRunnerInfoAdapter(
    recyclerView: RecyclerView,
    dataList: ObservableArrayList<UserInfo>
) {
    if (recyclerView.adapter == null) recyclerView.adapter = RunnerInfoAdapter(dataList)
    recyclerView.adapter?.notifyDataSetChanged()
}

@BindingAdapter("waitingUserInfoAdapter", "postAcceptListener")
fun setWaitingUserInfoAdapter(
    recyclerView: RecyclerView,
    dataList: ObservableArrayList<UserInfo>,
    listener: PostAcceptListener
) {
    if (recyclerView.adapter == null) recyclerView.adapter =
        WaitingRunnerInfoAdapter(dataList, listener)
    recyclerView.adapter?.notifyDataSetChanged()
}

@BindingAdapter("messageAdapter")
fun setMessageAdapter(
    recyclerView: RecyclerView,
    dataList: ObservableArrayList<Messages>
) {
    if(recyclerView.adapter == null) recyclerView.adapter =
        RunningTalkDetailAdapter(dataList)
    recyclerView.adapter?.notifyDataSetChanged()
    recyclerView.scrollToPosition(dataList.size - 1)
}

@BindingAdapter("bind:paceListAdapter", "bind:paceSelectListener")
fun setPaceListAdapter(
    recyclerView: RecyclerView,
    dataList: List<PaceSelectItem>,
    listener: PaceSelectListener
) {
    if(recyclerView.adapter == null) recyclerView.adapter = PaceInfoListAdapter(dataList, listener)
    recyclerView.adapter?.notifyDataSetChanged()
}

@BindingAdapter("bind:paceSimpleListAdapter", "bind:paceSimpleSelectListener")
fun setPaceSimpleSelectAdapter(
    recyclerView: RecyclerView,
    dataList: List<PaceSelectItem>,
    listener: PaceSelectListener
) {
    recyclerView.adapter?: run {
        recyclerView.adapter = PaceSimpleSelectListAdapter(listener)
    }
    val adapter = recyclerView.adapter
    recyclerView.itemAnimator = null
    if(adapter is PaceSimpleSelectListAdapter) adapter.submitList(dataList)
}