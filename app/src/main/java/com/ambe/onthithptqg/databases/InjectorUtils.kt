package com.ambe.onthithptqg.databases

import android.content.Context
import com.ambe.onthithptqg.databases.exam.ExamRepository
import com.ambe.onthithptqg.databases.exam.ExamViewModelFactory
import com.ambe.onthithptqg.databases.question.QuestionRepository
import com.ambe.onthithptqg.databases.question.QuestionViewModelFactory

/**
 *  Created by AMBE on 29/7/2019 at 11:10 AM.
 */
object InjectorUtils {
    private fun getQuestionRepository(context: Context): QuestionRepository {
        return QuestionRepository.getInstance(MyDb.getInstance(context.applicationContext).questionDao())
    }

    fun providerQuestionViewModelFactory(context: Context): QuestionViewModelFactory {
        val repository = getQuestionRepository(context)
        return QuestionViewModelFactory(repository)
    }


    private fun getExamRepository(context: Context): ExamRepository {
        return ExamRepository.getInstance(MyDb.getInstance(context.applicationContext).examDao())
    }

    fun providerExamViewModelFactory(context: Context): ExamViewModelFactory {
        val repository = getExamRepository(context)
        return ExamViewModelFactory(repository)
    }
}