package com.ambe.onthithptqg.ui.listexam

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.ambe.onthithptqg.R
import com.ambe.onthithptqg.interfaces.IOnClickExam
import com.ambe.onthithptqg.model.Exam
import com.ambe.onthithptqg.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_list_exam.*


class ListExamFragment : BaseFragment() {

    private val adapter = ExamAdapter()
    private var subject: String? = null
    private var type: String? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addControls()
        addEvents()

    }

    private fun addEvents() {
        img_back.setOnClickListener { navController.navigateUp() }
    }

    private fun addControls() {

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
        var list = ArrayList<Exam>()
        list.add(Exam("Đề thi minh họa lần 1", "Bộ GDDT", "90 phút", 90, 30))
        list.add(Exam("Đề thi minh họa lần 2", "Bộ GDDT", "90 phút", 90, 30))
        list.add(Exam("Đề thi minh họa lần 3", "Bộ GDDT", "90 phút", 90, 30))
        list.add(Exam("Đề thi minh họa lần 4", "Bộ GDDT", "90 phút", 90, 30))
        list.add(Exam("Đề thi minh họa lần 5", "Bộ GDDT", "90 phút", 90, 30))
        list.add(Exam("Đề thi minh họa lần 6", "Bộ GDDT", "90 phút", 90, 30))
        list.add(Exam("Đề thi minh họa lần 7", "Bộ GDDT", "90 phút", 90, 30))
        list.add(Exam("Đề thi minh họa lần 7", "Bộ GDDT", "90 phút", 90, 30))
        list.add(Exam("Đề thi minh họa lần 7", "Bộ GDDT", "90 phút", 90, 30))
        list.add(Exam("Đề thi minh họa lần 7", "Bộ GDDT", "90 phút", 90, 30))
        list.add(Exam("Đề thi minh họa lần 7", "Bộ GDDT", "90 phút", 90, 30))
        list.add(Exam("Đề thi minh họa lần 7", "Bộ GDDT", "90 phút", 90, 30))
        list.add(Exam("Đề thi minh họa lần 7", "Bộ GDDT", "90 phút", 90, 30))

        adapter.submitList(list)

        adapter.setOnClickExam(object : IOnClickExam {
            override fun onClickExam(exam: Exam) {

                navController.navigate(R.id.action_listExamFragment_to_questionFragment)

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
