package com.ambe.onthithptqg.databases.question

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.ambe.onthithptqg.model.Exam

/**
 *  Created by AMBE on 26/7/2019 at 15:23 PM.
 */
@Dao
interface ExamDao {
    @Query("select * from exam where monHoc = :sub")
    fun getExamBySub(sub: String): LiveData<List<Exam>>

    @Query("select * from exam")
    fun getExams(): LiveData<List<Exam>>
}