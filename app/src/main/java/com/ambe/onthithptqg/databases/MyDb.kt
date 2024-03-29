package com.ambe.onthithptqg.databases

import android.arch.persistence.room.Database
import android.arch.persistence.room.DatabaseConfiguration
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.ambe.onthithptqg.databases.question.ExamDao
import com.ambe.onthithptqg.databases.question.QuestionDao
import com.ambe.onthithptqg.helper.RoomAsset
import com.ambe.onthithptqg.model.Exam
import com.ambe.onthithptqg.model.Question


/**
 *  Created by AMBE on 22/7/2019 at 13:37 PM.
 */
private const val DATABASE_NAME = "my_db.db"

@Database(entities = [Question::class, Exam::class], version = 2, exportSchema = false)
abstract class MyDb : RoomDatabase() {

    abstract fun questionDao(): QuestionDao

    abstract fun examDao(): ExamDao




    companion object {
        @Volatile
        private var instance: MyDb? = null

        fun getInstance(context: Context): MyDb {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also {
                    instance = it
                }
            }
        }

        private fun buildDatabase(context: Context): MyDb {


//            return Room.databaseBuilder(context, MyDb::class.java, DATABASE_NAME)
//                .fallbackToDestructiveMigration()
//                .build()


            return RoomAsset.databaseBuilder(
                context.applicationContext, MyDb::class.java, DATABASE_NAME
            ).fallbackToDestructiveMigration().build()

        }


    }


}