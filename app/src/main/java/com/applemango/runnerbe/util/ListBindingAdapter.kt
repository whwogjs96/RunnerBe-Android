package com.applemango.runnerbe.util

import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.RecyclerView
import com.applemango.runnerbe.data.dto.Posting
import com.applemango.runnerbe.presentation.model.CreatorImageAndPosition
import com.applemango.runnerbe.data.dto.Room
import com.applemango.runnerbe.data.dto.UserInfo
import com.applemango.runnerbe.presentation.model.listener.AttendanceAccessionClickListener
import com.applemango.runnerbe.presentation.model.listener.BookMarkClickListener
import com.applemango.runnerbe.presentation.model.listener.MyPostClickListener
import com.applemango.runnerbe.presentation.screen.dialog.appliedrunner.WaitingRunnerInfoAdapter
import com.applemango.runnerbe.presentation.screen.dialog.postdetail.RunnerInfoAdapter
import com.applemango.runnerbe.presentation.screen.dialog.selectitem.SelectListData
import com.applemango.runnerbe.presentation.screen.dialog.selectitem.SelectListItemAdapter
import com.applemango.runnerbe.presentation.screen.fragment.bookmark.BookMarkAdapter
import com.applemango.runnerbe.presentation.screen.fragment.chat.RunningTalkAdapter
import com.applemango.runnerbe.presentation.screen.fragment.mypage.joinpost.JoinPostAdapter
import com.applemango.runnerbe.presentation.screen.fragment.mypage.mypost.MyPostAdapter
import com.applemango.runnerbe.presentation.screen.fragment.mypage.mypost.accession.AttendanceAccessionAdapter
import com.applemango.runnerbe.presentation.screen.fragment.mypage.mypost.see.AttendanceSeeAdapter
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
    dataList : ObservableArrayList<UserInfo>
) {
    if(recyclerView.adapter == null) {
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
    if(recyclerView.adapter == null) {
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

@BindingAdapter("runningTalkListAdapter")
fun setRunningTalkListAdapter(recyclerView: RecyclerView, dataList: ObservableArrayList<Room>) {
    if (recyclerView.adapter == null) {
        recyclerView.adapter = RunningTalkAdapter(dataList)
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

@BindingAdapter("runnerInfoAdapter")
fun setRunnerInfoAdapter(
    recyclerView: RecyclerView,
    dataList: ObservableArrayList<UserInfo>
) {
    if (recyclerView.adapter == null) recyclerView.adapter = RunnerInfoAdapter(dataList)
    recyclerView.adapter?.notifyDataSetChanged()
}

@BindingAdapter("waitingUserInfoAdapter")
fun setWaitingUserInfoAdapter(
    recyclerView: RecyclerView,
    dataList: ObservableArrayList<UserInfo>
) {
    if(recyclerView.adapter == null) recyclerView.adapter = WaitingRunnerInfoAdapter(dataList)
    recyclerView.adapter?.notifyDataSetChanged()
}