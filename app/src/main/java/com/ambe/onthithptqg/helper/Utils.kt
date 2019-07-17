package com.ambe.onthithptqg.helper

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.view.ViewGroup
import android.view.animation.BounceInterpolator

/**
 *  Created by AMBE on 17/7/2019 at 11:24 AM.
 */
object Utils {
    fun animateDialog(viewGroup: ViewGroup) {
        val set = AnimatorSet()
        val animatorX = ObjectAnimator.ofFloat(viewGroup, ViewGroup.SCALE_X, 0.7f, 1f)
        val animatorY = ObjectAnimator.ofFloat(viewGroup, ViewGroup.SCALE_Y, 0.7f, 1f)
        set.playTogether(animatorX, animatorY)
        set.interpolator = BounceInterpolator()
        set.duration = 500
        set.start()
    }

}