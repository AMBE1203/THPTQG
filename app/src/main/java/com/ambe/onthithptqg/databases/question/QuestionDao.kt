package com.ambe.onthithptqg.databases.question

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.ambe.onthithptqg.model.Question

/**
 *  Created by AMBE on 26/7/2019 at 15:23 PM.
 */
@Dao
interface QuestionDao {
    @Query("select * from question where note = :note")
    fun getQuestionNoted(note: Boolean): LiveData<List<Question>>
}