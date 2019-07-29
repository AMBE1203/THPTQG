package com.ambe.onthithptqg.databases.question

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

/**
 *  Created by AMBE on 29/7/2019 at 11:07 AM.
 */
class QuestionViewModelFactory(
    private val questionRepository: QuestionRepository
) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = QuestionViewModel(
        questionRepository
    ) as T

}