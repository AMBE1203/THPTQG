package com.ambe.onthithptqg.ui.listexam

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import com.ambe.onthithptqg.R
import com.ambe.onthithptqg.interfaces.IOnClickExam
import com.ambe.onthithptqg.model.Exam
import com.ambe.onthithptqg.model.ExamDiffCallback
import kotlinx.android.synthetic.main.item_exam.view.*


/**
 *  Created by AMBE on 24/7/2019 at 11:46 AM.
 */
class ExamAdapter : ListAdapter<Exam, ExamAdapter.ViewHolder>(ExamDiffCallback()) {


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {

        return ViewHolder(
            LayoutInflater.from(p0.context).inflate(
                R.layout.item_exam,
                p0,
                false
            )
        )

    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {

        val exam = getItem(p1)
        p0.apply {
            bind(exam)

        }
    }

    private var iOnClickExam: IOnClickExam? = null

    fun setOnClickExam(iOnClickExam: IOnClickExam) {
        this.iOnClickExam = iOnClickExam
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(exam: Exam) {
            itemView.txt_name.text = exam.ten
            itemView.txt_dia_chi.text = exam.diaChi
            itemView.txt_thoi_gian.text = "Thời gian: ${exam.thoiGian} - Số câu: ${exam.soCau}"
            val animation = AnimationUtils.loadAnimation(
                itemView.context,
                R.anim.item_animation_from_right
            )
            itemView.startAnimation(animation)

            itemView.setOnClickListener { iOnClickExam?.onClickExam(exam) }

        }

    }

}