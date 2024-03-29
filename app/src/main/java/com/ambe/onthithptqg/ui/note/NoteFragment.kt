package com.ambe.onthithptqg.ui.note


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.ambe.onthithptqg.R
import com.ambe.onthithptqg.databases.InjectorUtils
import com.ambe.onthithptqg.databases.question.QuestionViewModel
import com.ambe.onthithptqg.ui.BaseFragment
import com.google.gson.Gson


class NoteFragment : BaseFragment() {

    private val TAG = NoteFragment::class.java.simpleName
    private var viewModel: QuestionViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_note, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val factory = InjectorUtils.providerQuestionViewModelFactory(context!!)
        viewModel = ViewModelProviders.of(this, factory).get(QuestionViewModel::class.java)

        viewModel?.getQuestion()?.observe(viewLifecycleOwner, Observer {
            Log.e("AAAAAAAAAAA", Gson().toJson(it?.get(it.size-1)))
        })

    }

    companion object {
        @JvmStatic
        fun newInstance() = NoteFragment()
    }


}
