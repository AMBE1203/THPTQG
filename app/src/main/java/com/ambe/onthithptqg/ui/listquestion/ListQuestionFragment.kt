package com.ambe.onthithptqg.ui.listquestion

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
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
import com.ambe.onthithptqg.databases.InjectorUtils
import com.ambe.onthithptqg.databases.MyDb
import com.ambe.onthithptqg.databases.question.QuestionViewModel
import com.ambe.onthithptqg.helper.Const
import com.ambe.onthithptqg.interfaces.IOnClickNumber
import com.ambe.onthithptqg.model.Question
import com.ambe.onthithptqg.ui.BaseFragment
import com.ambe.onthithptqg.ui.view.tablayout.indicators.DachshundIndicator
import kotlinx.android.synthetic.main.fragment_list_question.*
import com.ambe.onthithptqg.helper.Hourglass
import com.ambe.onthithptqg.interfaces.IOnSelectedAnswer
import com.ambe.onthithptqg.ui.dialog.ResultDialog
import org.jetbrains.anko.doAsync
import java.text.SimpleDateFormat
import kotlin.collections.ArrayList


class ListQuestionFragment : BaseFragment(), IOnClickNumber, IOnSelectedAnswer {
    override fun onSelectedAnswer(position: String) {

        list[tab_question.currentPosition].luaChon = position

        listNumber.add(tab_question.currentPosition)


//        if (view_pager_question.currentItem != tab_question.childCount) {
//
//
//            view_pager_question.currentItem = view_pager_question.currentItem + 1
//
//
//        }
    }

    override fun clickNumber(position: Int) {

        view_pager_question.setCurrentItem(position, true)
        showListNumber()

    }

    private var isShowNumber = false

    private var timer: Hourglass? = null

    private var numberAdapter: NumberAdapter? = null

    private var list: List<Question> = ArrayList()

    private var listNumber = ArrayList<Int>()

    private var showDapAnViewModel: ShowDapAnViewModel? = null
    private var viewModel: QuestionViewModel? = null


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

        txt_nop_bai.setOnClickListener { showDialogResult() }

        img_back.setOnClickListener {
            showDapAnViewModel?.setIsShowDapAn(false)

            navController.navigateUp()
        }
    }

    private fun showDialogResult() {
        var result = ResultDialog(context!!)

        var soCauDung = 0
        var soCauSai = 0

        for (question in list) {
            if (question.luaChon != "") {
                if (question.luaChon == question.dapAnDung) {
                    soCauDung++
                } else {
                    soCauSai++
                }
            }
        }

        var soCauDalam = soCauDung + soCauSai
        var soCauChuaLam = list.size - soCauDalam


        result.setResults(soCauDung, soCauSai, soCauDalam, soCauChuaLam)

        result.setListener(object : ResultDialog.IOnResultDialogListener {
            override fun onCancel() {

            }

            override fun onAgree(time: String) {

                view_pager_question.setCurrentItem(0, true)
                showDapAnViewModel?.setIsShowDapAn(true)
                if (timer != null) {
                    timer!!.pauseTimer()
                }
                result.dismiss()
            }
        })

        result.show()
    }

    private fun addControls() {

        showDapAnViewModel = ViewModelProviders.of(activity!!).get(ShowDapAnViewModel::class.java)

        var factory = InjectorUtils.providerQuestionViewModelFactory(context!!)
        viewModel = ViewModelProviders.of(this, factory).get(QuestionViewModel::class.java)

        var maDe = arguments?.getString(Const.MA_DE, "")
        if (maDe != "") {


            viewModel?.getQuestionsByMaDe(maDe!!)?.observe(viewLifecycleOwner, Observer {
                if (it != null) {

                    list = it

                    stupidDummyFun()
                }

            })
        }

//        doAsync {
//
//            for (l in list) {
//                MyDb.getInstance(context!!).questionDao().insertQuestion(l)
//            }
//
//        }

        var soCau = arguments?.getInt(Const.SO_CAU, -1)
        var listNumber: ArrayList<Int> = ArrayList()

        if (soCau != null && soCau != -1) {


            for (i in 0 until soCau) {
                listNumber.add(i + 1)
            }
        }


        var grid = GridLayoutManager(activity, 3, GridLayoutManager.HORIZONTAL, false)
        rcv_number.setHasFixedSize(true)
        rcv_number.layoutManager = grid
        numberAdapter = NumberAdapter(listNumber, this)
        rcv_number.adapter = numberAdapter


        var thoiGian = arguments?.getString(Const.THOI_GIAN,"")
        if (thoiGian!!.isNotEmpty()) {


            var simDate = SimpleDateFormat("mm:ss")

            timer = object : Hourglass() {


                override fun onTimerTick(timeRemaining: Long) {
                    txt_time.text = simDate.format(timeRemaining)
                }

                override fun onTimerFinish() {
                    txt_time.text = "Finish!"
                    showDialogResult()
                }


            }

            timer!!.setTime(thoiGian.toLong().times(60).times(1000))
            timer!!.setInterval(1000)
        }


    }

    private fun stupidDummyFun() {
        view_pager_question.adapter =
            PagerAdapter((context as MainActivity).supportFragmentManager, list, this)
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

    override fun onPause() {
        super.onPause()
        if (timer != null) {
            timer!!.pauseTimer()
        }
    }

    override fun onResume() {
        super.onResume()
        if (timer != null) {
            timer!!.resumeTimer()
        }
    }

    fun onBack() {
        if (isShowNumber) {
            showListNumber()
        } else {

            showDapAnViewModel?.setIsShowDapAn(false)
            navController.navigateUp()
        }
    }


    private fun showListNumber() {
        // todo show list number of question

        if (!isShowNumber) {

            csl_number.visibility = View.VISIBLE
            isShowNumber = true

            numberAdapter!!.setCurrentQuetstion(tab_question.currentPosition)


            if (listNumber.size != 0) {


                numberAdapter!!.setListQuestion(listNumber)
            }


        } else {
            csl_number.visibility = View.GONE
            isShowNumber = false
        }
    }


    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() = ListQuestionFragment()
    }
}
