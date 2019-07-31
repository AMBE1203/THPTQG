package com.ambe.onthithptqg.model

import android.support.v7.util.DiffUtil

/**
 *  Created by AMBE on 24/7/2019 at 11:51 AM.
 */
class ExamDiffCallback : DiffUtil.ItemCallback<Exam>() {
    override fun areItemsTheSame(oldItem: Exam, newItem: Exam): Boolean {
        return oldItem.tenDe == newItem.tenDe
    }

    override fun areContentsTheSame(oldItem: Exam, newItem: Exam): Boolean {
        return oldItem.equals(newItem)
    }
}