package com.ambe.onthithptqg.ui.dialog

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import java.lang.Exception

/**
 *  Created by AMBE on 15/6/2019 at 11:32 AM.
 */
abstract class BaseDialog(context: Context) : AlertDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        setUpLayout()
        initView()


        setAnimation()
    }

    abstract fun setAnimation()

    abstract fun initView()

    abstract fun getLayout(): Int

    private fun setUpLayout() {
        if (window != null) {
            window?.clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM)
            try {

                window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                requestWindowFeature(Window.FEATURE_NO_TITLE)

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}