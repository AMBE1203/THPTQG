package com.ambe.onthithptqg.ui.dialog

import android.content.Context
import com.ambe.onthithptqg.R
import com.ambe.onthithptqg.helper.Utils
import com.ambe.onthithptqg.interfaces.IOnSimpleDialogListener
import kotlinx.android.synthetic.main.dialog_result.*

/**
 *  Created by AMBE on 27/7/2019 at 11:25 AM.
 */
class ResultDialog(context: Context) : BaseDialog(context) {
    override fun setAnimation() {

        Utils.animateDialog(vgr_dialog_result)
    }

    private var soCauDung: Int = 0
    private var soCauSai: Int = 0
    private var soCauDaLam: Int = 0
    private var soCauChuaLam: Int = 0

    fun setResults(cauDung: Int, cauSai: Int, cauDaLam: Int, cauChuaLam: Int) {

        soCauDung = cauDung
        soCauSai = cauSai
        soCauDaLam = cauDaLam
        soCauChuaLam = cauChuaLam


    }

    override fun initView() {

        setCanceledOnTouchOutside(false)
        lnl_xem_dap_an.setOnClickListener { listener?.onAgree("OK") }

        txt_so_cau_dung.text = "$soCauDung/${(soCauChuaLam + soCauDaLam)}"
        txt_so_cau_sai.text = "$soCauSai/${(soCauChuaLam + soCauDaLam)}"
        txt_so_cau_da_lam.text = "$soCauDaLam/${(soCauChuaLam + soCauDaLam)}"
        txt_so_cau_chua_lam.text = "$soCauChuaLam/${(soCauChuaLam + soCauDaLam)}"
    }

    override fun getLayout(): Int {

        return R.layout.dialog_result
    }

    private var listener: IOnResultDialogListener? = null

    fun setListener(listener: IOnResultDialogListener): ResultDialog {
        this.listener = listener
        return this
    }

    interface IOnResultDialogListener : IOnSimpleDialogListener

}