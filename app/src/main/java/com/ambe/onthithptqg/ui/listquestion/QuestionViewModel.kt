package com.ambe.onthithptqg.ui.listquestion

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

/**
 *  Created by AMBE on 27/7/2019 at 14:33 PM.
 */
class QuestionViewModel : ViewModel() {
    private val isShowDapAn = MutableLiveData<Boolean>()

    fun setIsShowDapAn(boolean: Boolean) {
        isShowDapAn.postValue(boolean)
    }

    fun getIsShowDapAn(): MutableLiveData<Boolean> {
        return isShowDapAn
    }
}