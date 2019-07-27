package com.ambe.onthithptqg.ui.listquestion

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.ambe.onthithptqg.interfaces.IOnSelectedAnswer
import com.ambe.onthithptqg.model.Question
import com.ambe.onthithptqg.ui.question.QuestionFragment

/**
 *  Created by AMBE on 25/7/2019 at 11:14 AM.
 */
class PagerAdapter(
    fm: FragmentManager,
    private var list: List<Question>,
    private var iOnSelectedAnswer: IOnSelectedAnswer

) : FragmentStatePagerAdapter(fm) {


    override fun getCount(): Int {
        return list.size
    }


    override fun getItem(i: Int): Fragment {
        return QuestionFragment.newInstance(iOnSelectedAnswer, list[i])
    }

    override fun getPageTitle(position: Int): CharSequence {
        return "${(position + 1)}"
    }
}