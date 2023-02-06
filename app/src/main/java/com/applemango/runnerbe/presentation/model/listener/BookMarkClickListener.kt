package com.applemango.runnerbe.presentation.model.listener

import com.applemango.runnerbe.data.dto.Posting

interface BookMarkClickListener {
    fun onClick(post: Posting)
}