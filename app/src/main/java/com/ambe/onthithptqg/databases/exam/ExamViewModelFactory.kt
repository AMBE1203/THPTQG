package com.ambe.onthithptqg.databases.exam

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

/**
 *  Created by AMBE on 29/7/2019 at 16:30 PM.
 */
class ExamViewModelFactory(
    private val examRepository: ExamRepository
) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T  = ExamViewModel(examRepository) as T
}