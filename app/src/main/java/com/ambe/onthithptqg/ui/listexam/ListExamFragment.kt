package com.ambe.onthithptqg.ui.listexam

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.ambe.onthithptqg.R
import com.ambe.onthithptqg.databases.InjectorUtils
import com.ambe.onthithptqg.databases.exam.ExamViewModel
import com.ambe.onthithptqg.helper.Const
import com.ambe.onthithptqg.interfaces.IOnClickExam
import com.ambe.onthithptqg.model.Exam
import com.ambe.onthithptqg.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_list_exam.*


class ListExamFragment : BaseFragment() {

    private val adapter = ExamAdapter()
    private var subject: String? = null
    private var type: String? = null
    private var viewModel: ExamViewModel? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addControls()
        addEvents()

    }

    private fun addEvents() {
        img_back.setOnClickListener { navController.navigateUp() }
    }

    private fun addControls() {

        var factory = InjectorUtils.providerExamViewModelFactory(context!!)
        viewModel = ViewModelProviders.of(this, factory).get(ExamViewModel::class.java)

        subject = arguments?.getString("subject")


        type = arguments?.getString("type")
        txt_ten_mon.text = subject
        txt_ten_lua_chon.text = type

        val linear = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rcv_exam.setHasFixedSize(true)
        rcv_exam.layoutManager = linear

        rcv_exam.adapter = adapter

        subscribeUi()

    }

    private fun subscribeUi() {
        viewModel?.getExamBySub(subject!!)?.observe(viewLifecycleOwner, Observer {
            if (it != null) {

                Log.e("AMBE1203", it.size.toString() + "   $subject")

                adapter.submitList(it)

            }

        })


        adapter.setOnClickExam(object : IOnClickExam {
            override fun onClickExam(exam: Exam) {

                var bundle = Bundle()
                bundle.putString(Const.MA_DE, exam.maDe)
                bundle.putInt(Const.SO_CAU, exam.soCau)
                bundle.putString(Const.THOI_GIAN, exam.thoiGian.split(" ")[0])

                navController.navigate(R.id.action_listExamFragment_to_questionFragment, bundle)

            }
        })
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_exam, container, false)
    }

    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() = ListExamFragment()
    }
}
