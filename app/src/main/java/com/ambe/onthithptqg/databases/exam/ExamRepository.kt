package com.ambe.onthithptqg.databases.exam

import com.ambe.onthithptqg.databases.question.ExamDao

/**
 *  Created by AMBE on 29/7/2019 at 16:26 PM.
 */
class ExamRepository private constructor(private val examDao: ExamDao) {

    fun getExamBySub(sub: String) = examDao.getExamBySub(sub)

    companion object{
        @Volatile
        private var instance : ExamRepository? =null

        fun getInstance(examDao: ExamDao) = instance ?: synchronized(this){
            instance ?: ExamRepository(examDao).also {
                instance = it
            }
        }
    }

}