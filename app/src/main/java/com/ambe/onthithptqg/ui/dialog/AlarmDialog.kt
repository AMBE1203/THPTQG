package com.ambe.onthithptqg.ui.dialog

import android.content.Context
import com.ambe.onthithptqg.R
import com.ambe.onthithptqg.helper.Utils
import com.ambe.onthithptqg.interfaces.IOnSimpleDialogListener
import kotlinx.android.synthetic.main.dialog_alarm.*

/**
 *  Created by AMBE on 23/7/2019 at 10:25 AM.
 */
class AlarmDialog(context: Context) : BaseDialog(context) {
    override fun setAnimation() {
        Utils.animateDialog(vgr_dialog_alert)
    }

    override fun initView() {
        lnl_cancel.setOnClickListener { listener?.onCancel() }
        lnl_ok.setOnClickListener { listener?.onAgree() }
    }

    override fun getLayout(): Int {
        return R.layout.dialog_alarm
    }


    private var listener: IOnAlertDialogListener? = null

    fun setListener(listener: IOnAlertDialogListener): AlarmDialog {
        this.listener = listener
        return this
    }

    interface IOnAlertDialogListener : IOnSimpleDialogListener

}