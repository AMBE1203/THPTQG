package com.ambe.onthithptqg.ui.question

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

import com.ambe.onthithptqg.R
import com.ambe.onthithptqg.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_question.*


class QuestionFragment : BaseFragment() {


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

        txt_a.setDisplayText(
            "            $(ax^2 + bx + c = 0)$ or displayed formula: $ sum_{i=0}^n i^2 $= frac{(n^2+n)(2n+1)}{6}$"
        )

        txt_b.setDisplayText(" d ")
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


    }

    private fun addControls() {
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


    }


    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() = QuestionFragment()
    }
}
