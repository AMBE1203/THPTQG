package com.ambe.onthithptqg.databases.question

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.ambe.onthithptqg.model.Question

/**
 *  Created by AMBE on 26/7/2019 at 15:23 PM.
 */
@Dao
interface QuestionDao {
    @Query("select * from question where note = :note")
    fun getQuestionNoted(note: Boolean): LiveData<List<Question>>

    @Query("select * from question where maDe = :maDe")
    fun getQuestionsByMaDe(maDe: String): LiveData<List<Question>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertQuestion(question: Question)

    @Query("select * from question")
    fun getQuetsions(): LiveData<List<Question>>
}