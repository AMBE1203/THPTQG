package com.ambe.onthithptqg.ui

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation

import com.ambe.onthithptqg.R
import com.ambe.onthithptqg.ui.dialog.LoadingDialog

/**
 *  Created by AMBE on 15/6/2019 at 11:30 AM.
 */
abstract class BaseFragment : Fragment() {
    protected lateinit var navController: NavController

    private var loadingDialog: LoadingDialog? = null


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        navController = Navigation.findNavController(context as Activity, R.id.nav_host_fragment)
    }


    fun showLoading() {
        if (loadingDialog == null) {
            context?.let {
                loadingDialog = LoadingDialog(it)
//                loadingDialog?.setCanceledOnTouchOutside(false)
            }
        }

        loadingDialog?.show()
    }

    fun hideLoading() {
        loadingDialog?.dismiss()
    }


}