package com.ambe.onthithptqg.ui.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ambe.onthithptqg.R
import com.ambe.onthithptqg.interfaces.IStateToolbarMain
import com.ambe.onthithptqg.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : BaseFragment(), View.OnClickListener {

    private var stateToolbarMain: IStateToolbarMain? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is IStateToolbarMain) {
            stateToolbarMain = context
        }
    }

    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.lnl_toan -> goToSubjectFrgament(getString(R.string.to_n))
            R.id.lnl_ly -> goToSubjectFrgament(getString(R.string.vat_ly))
            R.id.lnl_hoa -> goToSubjectFrgament(getString(R.string.hoa_hoc))
            R.id.lnl_sinh -> goToSubjectFrgament(getString(R.string.sinh_hoc))
            R.id.lnl_van -> goToSubjectFrgament(getString(R.string.ngu_van))
            R.id.lnl_su -> goToSubjectFrgament(getString(R.string.lich_su))
            R.id.lnl_dia -> goToSubjectFrgament(getString(R.string.dia_ly))
            R.id.lnl_anh -> goToSubjectFrgament(getString(R.string.tieng_anh))
            R.id.lnl_gdcd -> goToSubjectFrgament(getString(R.string.gdcd))
        }


    }

    private fun goToSubjectFrgament(subject: String) {
        var bundle = Bundle()
        bundle.putString("subject", subject)
        navController.navigate(R.id.action_mainFragment_to_subjectsFragment, bundle)
        stateToolbarMain?.hideToolbar()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addControls()

        addEvents()
    }

    private fun addControls() {
    }

    private fun addEvents() {
        lnl_toan.setOnClickListener(this)
        lnl_ly.setOnClickListener(this)
        lnl_hoa.setOnClickListener(this)
        lnl_sinh.setOnClickListener(this)
        lnl_van.setOnClickListener(this)
        lnl_su.setOnClickListener(this)
        lnl_dia.setOnClickListener(this)
        lnl_anh.setOnClickListener(this)
        lnl_gdcd.setOnClickListener(this)

    }


    companion object {
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}
