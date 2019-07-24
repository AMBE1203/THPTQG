package com.ambe.onthithptqg.ui.dialog

import android.content.Context

import com.ambe.onthithptqg.R
import com.ambe.onthithptqg.helper.Utils
import com.ambe.onthithptqg.interfaces.IOnSimpleDialogListener
import kotlinx.android.synthetic.main.dialog_exit_alert.*

/**
 *  Created by AMBE on 15/6/2019 at 13:45 PM.
 */
class ExitAlertDialog(context: Context) : BaseDialog(context) {

    override fun setAnimation() {

        Utils.animateDialog(vgr_dialog_exit_alert)
    }

    override fun initView() {

        txt_no.setOnClickListener { listener?.onCancel() }
        txt_yes.setOnClickListener { listener?.onAgree("aaaaaa") }
    }

    override fun getLayout(): Int {
        return R.layout.dialog_exit_alert
    }


    private var listener: IOnExitAlertDialogListener? = null

    fun setListener(listener: IOnExitAlertDialogListener): ExitAlertDialog {
        this.listener = listener
        return this
    }

    interface IOnExitAlertDialogListener : IOnSimpleDialogListener

}