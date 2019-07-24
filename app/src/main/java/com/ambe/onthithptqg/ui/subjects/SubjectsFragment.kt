package com.ambe.onthithptqg.ui.subjects

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.ambe.onthithptqg.R
import com.ambe.onthithptqg.helper.Const
import com.ambe.onthithptqg.interfaces.IStateToolbarMain
import com.ambe.onthithptqg.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_subjects.*

class SubjectsFragment : BaseFragment() {

    private var subject: String = ""

    private var stateToolbarMain: IStateToolbarMain? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is IStateToolbarMain) {
            stateToolbarMain = context
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_subjects, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addControls()
        addEvents()

    }

    private fun addEvents() {
        img_back.setOnClickListener {
            stateToolbarMain?.showToolbar()

            navController.navigateUp()
        }

        lnl_de_thi.setOnClickListener {
            var bundle = Bundle()
            bundle.putString("subject", subject)
            bundle.putString("type", "Đề thi minh họa")
            navController.navigate(R.id.action_subjectsFragment_to_listExamFragment, bundle)
        }

    }

    private fun addControls() {
        subject = arguments?.get("subject") as String
        txt_name_sub.text = subject

    }


    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() = SubjectsFragment()
    }
}
