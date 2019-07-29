package com.ambe.onthithptqg.databases.question

import android.arch.lifecycle.ViewModel
import com.ambe.onthithptqg.databases.question.QuestionRepository

/**
 *  Created by AMBE on 29/7/2019 at 11:08 AM.
 */
class QuestionViewModel internal constructor(
    private val questionRepository: QuestionRepository
) : ViewModel() {

    fun getQuestionNoted(note: Boolean) = questionRepository.getQuestionNoted(note)

}