package com.ambe.onthithptqg.ui.question

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ambe.onthithptqg.R
import com.ambe.onthithptqg.interfaces.IOnSelectedAnswer
import com.ambe.onthithptqg.model.Question
import com.ambe.onthithptqg.ui.BaseFragment
import com.ambe.onthithptqg.ui.listquestion.QuestionViewModel
import kotlinx.android.synthetic.main.fragment_question.*


class QuestionFragment : BaseFragment() {

    private var selectedAnswer: IOnSelectedAnswer? = null
    private var question: Question? = null
    private var questionViewModel: QuestionViewModel? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addControls()
        addEvents()
    }

    private fun addEvents() {

        lnl_a.setOnClickListener {
            chooseAnswer(txtA, txtB, txtC, txtD)
        }

        txt_a.setOnClickListener {
            chooseAnswer(txtA, txtB, txtC, txtD)
        }

        lnl_b.setOnClickListener {
            chooseAnswer(txtB, txtA, txtC, txtD)
        }

        lnl_c.setOnClickListener {
            chooseAnswer(txtC, txtB, txtA, txtD)
        }


        lnl_d.setOnClickListener {
            chooseAnswer(txtD, txtB, txtC, txtA)
        }

        txt_b.setOnClickListener {
            chooseAnswer(txtB, txtA, txtC, txtD)
        }

        txt_c.setOnClickListener {
            chooseAnswer(txtC, txtB, txtA, txtD)
        }


        txt_d.setOnClickListener {
            chooseAnswer(txtD, txtB, txtC, txtA)
        }


    }

    private fun chooseAnswer(
        lnl1: TextView?,
        lnl2: TextView?,
        lnl3: TextView?,
        lnl4: TextView?
    ) {

        lnl1?.setBackgroundResource(R.drawable.bg_answer_selected)
        lnl2?.setBackgroundResource(R.drawable.bg_answer_no_selected)
        lnl3?.setBackgroundResource(R.drawable.bg_answer_no_selected)
        lnl4?.setBackgroundResource(R.drawable.bg_answer_no_selected)

        // todo auto next question when user choose

        selectedAnswer?.onSelectedAnswer(lnl1?.text.toString())


//        Handler().postDelayed({
//            selectedAnswer?.onSelectedAnswer(lnl1?.text.toString())
//
//        }, 500)


    }

    private fun addControls() {

        questionViewModel = ViewModelProviders.of(activity!!).get(QuestionViewModel::class.java)

        txt_a.settings.builtInZoomControls = true
        txt_b.settings.builtInZoomControls = true
        txt_c.settings.builtInZoomControls = true
        txt_d.settings.builtInZoomControls = true
        txt_cau_hoi.settings.builtInZoomControls = true
        txt_giai_thic_dap_an.settings.builtInZoomControls = true

        txt_a.settings.displayZoomControls = false
        txt_b.settings.displayZoomControls = false
        txt_c.settings.displayZoomControls = false
        txt_d.settings.displayZoomControls = false
        txt_cau_hoi.settings.displayZoomControls = false
        txt_giai_thic_dap_an.settings.displayZoomControls = false

        txt_a.setTextColor(R.color.colorBlack)
        txt_b.setTextColor(R.color.colorBlack)
        txt_c.setTextColor(R.color.colorBlack)
        txt_d.setTextColor(R.color.colorBlack)
        txt_cau_hoi.setTextColor(R.color.colorBlack)

        if (question != null) {
            txt_cau_hoi.setDisplayText(question!!.cauHoi)
            txt_a.setDisplayText(question!!.dapAnA)
            txt_b.setDisplayText(question!!.dapAnB)
            txt_c.setDisplayText(question!!.dapAnC)
            txt_d.setDisplayText(question!!.dapAnD)
            txt_giai_thic_dap_an.setDisplayText(question!!.giaiThich)

            if (question!!.luaChon != "") {
                when (question!!.luaChon) {
                    "A" -> txtA.setBackgroundResource(R.drawable.bg_answer_selected)
                    "B" -> txtB.setBackgroundResource(R.drawable.bg_answer_selected)
                    "C" -> txtC.setBackgroundResource(R.drawable.bg_answer_selected)
                    "D" -> txtD.setBackgroundResource(R.drawable.bg_answer_selected)
                }
            }

            questionViewModel?.getIsShowDapAn()?.observe(viewLifecycleOwner, Observer {
                if (it == true) {
                    lnl_giai_thich.visibility = View.VISIBLE
                } else {
                    lnl_giai_thich.visibility = View.GONE

                }
            })
        }


        // todo show loading

//        txt_a.webChromeClient = object : WebChromeClient() {
//
//            override fun onProgressChanged(view: WebView, progress: Int) {
//
//                if (progress <= 10) {
//                    showLoading()
//                } else if (progress == 100) {
//                    hideLoading()
//
//                }
//            }
//        }

    }


    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(i: IOnSelectedAnswer, q: Question) = QuestionFragment().apply {
            selectedAnswer = i
            question = q
        }
    }
}
