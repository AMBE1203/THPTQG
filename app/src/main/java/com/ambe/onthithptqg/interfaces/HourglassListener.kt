package com.ambe.onthithptqg.interfaces

import com.ambe.onthithptqg.helper.Hourglass



/**
 *  Created by AMBE on 25/7/2019 at 16:06 PM.
 */
interface HourglassListener {
    /**
     * Method to be called every second by the [Hourglass]
     *
     * @param timeRemaining: Time remaining in milliseconds.
     */
    fun onTimerTick(timeRemaining: Long)

    /**
     * Method to be called by [Hourglass] when the thread is getting  finished
     */
    fun onTimerFinish()
}