package com.ambe.onthithptqg.ui.listquestion

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ambe.onthithptqg.R
import com.ambe.onthithptqg.interfaces.IOnClickNumber
import kotlinx.android.synthetic.main.item_number.view.*

/**
 *  Created by AMBE on 25/7/2019 at 14:24 PM.
 */
class NumberAdapter(var arrayList: ArrayList<Int>, var iOnClickNumber: IOnClickNumber) :
    RecyclerView.Adapter<NumberAdapter.ViewHolder>() {


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
        }
    }
}