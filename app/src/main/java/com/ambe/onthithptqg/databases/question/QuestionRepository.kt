package com.ambe.onthithptqg.databases.question

/**
 *  Created by AMBE on 29/7/2019 at 11:02 AM.
 */
class QuestionRepository private constructor(private val questionDao: QuestionDao) {

    fun getQuestionNoted(note: Boolean) = questionDao.getQuestionNoted(note)

    fun getQuestionsByMaDe(maDe: String) = questionDao.getQuestionsByMaDe(maDe)

    fun getQuestion() = questionDao.getQuetsions()

    companion object {

        @Volatile
        private var instance: QuestionRepository? = null

        fun getInstance(questionDao: QuestionDao) = instance
            ?: synchronized(this) {
                instance
                    ?: QuestionRepository(questionDao).also { instance = it }
            }


    }
}