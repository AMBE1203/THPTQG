package com.ambe.onthithptqg.ui.listquestion

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.ambe.onthithptqg.MainActivity

import com.ambe.onthithptqg.R
import com.ambe.onthithptqg.interfaces.IOnClickNumber
import com.ambe.onthithptqg.model.Question
import com.ambe.onthithptqg.ui.BaseFragment
import com.ambe.onthithptqg.ui.view.tablayout.indicators.DachshundIndicator
import kotlinx.android.synthetic.main.fragment_list_question.*


class ListQuestionFragment : BaseFragment(), IOnClickNumber {
    override fun clickNumber(position: Int) {

        view_pager_question.setCurrentItem(position, true)
        showListNumber()

    }

    private var isShowNumbew = false


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_question, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addControls()
        addEvents()

    }

    private fun addEvents() {

        view_opacity.setOnClickListener { showListNumber() }
    }

    private fun addControls() {
        var list: List<Question> = ArrayList()

        (list as ArrayList).add(Question("1"))
        (list as ArrayList).add(Question("2"))
        (list as ArrayList).add(Question("3"))
        (list as ArrayList).add(Question("4"))
        (list as ArrayList).add(Question("5"))
        (list as ArrayList).add(Question("6"))
        (list as ArrayList).add(Question("7"))
        (list as ArrayList).add(Question("8"))
        (list as ArrayList).add(Question("9"))
        (list as ArrayList).add(Question("10"))

        var listNumber: ArrayList<Int> = ArrayList()

        for (i in 0 until list.size) {
            listNumber.add(i + 1)
        }


        var grid = GridLayoutManager(activity, 3, GridLayoutManager.HORIZONTAL, false)
        rcv_number.setHasFixedSize(true)
        rcv_number.layoutManager = grid
        var numberAdapter = NumberAdapter(listNumber, this)
        rcv_number.adapter = numberAdapter



        view_pager_question.adapter =
            PagerAdapter((context as MainActivity).supportFragmentManager, list)
        tab_question.setupWithViewPager(view_pager_question)
        tab_question.animatedIndicator = DachshundIndicator(tab_question)

        var tabStrip: LinearLayout = tab_question.getChildAt(0) as LinearLayout


        for (i in 0 until tabStrip.childCount) {

            tabStrip.getChildAt(i).setOnTouchListener { v, event ->
                when (event.action) {

                    MotionEvent.ACTION_DOWN -> {
                        val view = v as LinearLayout
                        view.setBackgroundResource(R.color.colorAccent)

                    }
                    MotionEvent.ACTION_UP -> {
                        val view = v as LinearLayout
                        view.setBackgroundResource(R.color.transparent)

                        showListNumber()

                    }
                    MotionEvent.ACTION_CANCEL -> {
                        val view = v as LinearLayout
                        view.setBackgroundResource(R.color.transparent)

                    }
                }
                true
            }

        }


    }

    private fun showListNumber() {
        // todo show list number of question

        if (!isShowNumbew) {

            csl_number.visibility = View.VISIBLE
            isShowNumbew = true

        } else {
            csl_number.visibility = View.GONE
            isShowNumbew = false
        }
    }


    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() = ListQuestionFragment()
    }
}
