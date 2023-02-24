package com.applemango.runnerbe.util

import com.applemango.runnerbe.R
import com.applemango.runnerbe.presentation.model.RunnerDiligence

object ResourceUtil {

    fun getRunnerDiligenceImage(diligence: String?) = when (diligence) {
        RunnerDiligence.EFFORT_RUNNER.value -> {
            R.drawable.ic_effort_runner_face
        }
        RunnerDiligence.ERROR_RUNNER.value -> {
            R.drawable.ic_error_runner_face
        }
        RunnerDiligence.SINCERITY_RUNNER.value -> {
            R.drawable.ic_sincerity_runner_face
        }
        else -> {
            R.drawable.ic_effort_runner_face
        }
    }

}