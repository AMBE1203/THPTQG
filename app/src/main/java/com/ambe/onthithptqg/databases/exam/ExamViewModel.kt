package com.ambe.onthithptqg.databases.exam

import android.arch.lifecycle.ViewModel

/**
 *  Created by AMBE on 29/7/2019 at 16:30 PM.
 */
class ExamViewModel internal constructor(
    private val examRepository: ExamRepository
) : ViewModel() {

    fun getExamBySub(sub: String) = examRepository.getExamBySub(sub)

    fun getExams() = examRepository.getExams()
}