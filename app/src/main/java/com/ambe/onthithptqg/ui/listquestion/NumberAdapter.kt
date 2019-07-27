package com.ambe.onthithptqg.ui.listquestion

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ambe.onthithptqg.R
import com.ambe.onthithptqg.interfaces.IOnClickNumber
import kotlinx.android.synthetic.main.fragment_list_question.*
import kotlinx.android.synthetic.main.item_number.view.*

/**
 *  Created by AMBE on 25/7/2019 at 14:24 PM.
 */
class NumberAdapter(var arrayList: ArrayList<Int>, var iOnClickNumber: IOnClickNumber) :
    RecyclerView.Adapter<NumberAdapter.ViewHolder>() {

    private var currentQuestion: Int? = null
    private var listQuesttion: ArrayList<Int>? = null


    fun setCurrentQuetstion(number: Int) {
        currentQuestion = number
        notifyDataSetChanged()

    }

    fun setListQuestion(list: ArrayList<Int>) {
        listQuesttion = list
    }


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {

        return ViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.item_number, p0, false))
    }

    override fun getItemCount(): Int {

        return arrayList.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {

        var item = arrayList[p1]
        p0.apply {
            bind(item)
            itemView.setOnClickListener {
                iOnClickNumber.clickNumber(p1)
            }

        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(int: Int) {
            itemView.txt_number.text = "$int"

            if (int == (currentQuestion!!.plus(1))) {
                itemView.txt_number.setBackgroundResource(R.drawable.bg_current_number)
            } else {
                itemView.txt_number.setBackgroundResource(R.drawable.bg_number)

            }

            if (listQuesttion != null && listQuesttion!!.size > 0) {

                for (i in listQuesttion!!) {
                    Log.e("AAAAAAAAAA", " aaaa $i")

                    if (int == i.plus(1)) {
                        if (int == currentQuestion!!.plus(1)) {
                            itemView.txt_number.setBackgroundResource(R.drawable.bg_checked_and_current_number)
                        } else {
                            itemView.txt_number.setBackgroundResource(R.drawable.bg_checked_number)
                        }
                    }


                }
            }
        }
    }
}