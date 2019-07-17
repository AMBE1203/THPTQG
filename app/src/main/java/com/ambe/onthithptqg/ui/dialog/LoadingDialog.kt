package com.ambe.onthithptqg.ui.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import com.ambe.onthithptqg.R


/**
 *  Created by AMBE on 15/6/2019 at 11:39 AM.
 */
class LoadingDialog(context: Context) : Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_loading)
    }
//

}