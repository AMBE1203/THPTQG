package com.ambe.onthithptqg.ui.dialog

import android.content.Context
import android.content.res.Resources
import android.graphics.Paint
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.widget.EditText
import android.widget.NumberPicker
import android.widget.TimePicker
import com.ambe.onthithptqg.R
import com.ambe.onthithptqg.helper.Const
import com.ambe.onthithptqg.helper.PrefUtils
import com.ambe.onthithptqg.helper.Utils
import com.ambe.onthithptqg.interfaces.IOnSimpleDialogListener
import kotlinx.android.synthetic.main.dialog_alarm.*
import java.util.*


/**
 *  Created by AMBE on 23/7/2019 at 10:25 AM.
 */
class AlarmDialog(context: Context) : BaseDialog(context), TimePicker.OnTimeChangedListener {

    private var time: String? = null

    override fun onTimeChanged(view: TimePicker?, i: Int, i1: Int) {
        var hourTam = i
        val hour: String
        val minute: String
        if (hourTam > 12) {
            hourTam = hourTam - 12
        }
        if (hourTam < 10) {
            hour = "0$hourTam"
        } else {
            hour = "" + hourTam
        }
        if (i1 < 10) {
            minute = "0$i1"
        } else {
            minute = "" + i1
        }
        time = hour + ":" + minute + if (i > 12) " pm" else " am"
    }

    override fun setAnimation() {
        Utils.animateDialog(vgr_dialog_alert)
    }

    override fun initView() {

        applyStyLing(time_picker)
        time_picker.setOnTimeChangedListener(this)

        lnl_cancel.setOnClickListener { listener?.onCancel() }
        lnl_ok.setOnClickListener {
            if (time != null) {
                var prefUtils = PrefUtils.getInstance(context)
                prefUtils.putString(Const.GIO_HOC_BAI, time!!)
                listener?.onAgree(time!!)

            }
        }
    }

    override fun getLayout(): Int {
        Locale.setDefault(Locale.US)
        val configuration = context.resources.configuration
        configuration.setLocale(Locale.US)
        configuration.setLayoutDirection(Locale.US)

        context.createConfigurationContext(configuration)
        return R.layout.dialog_alarm
    }


    private var listener: IOnAlertDialogListener? = null

    fun setListener(listener: IOnAlertDialogListener): AlarmDialog {
        this.listener = listener
        return this
    }

    private fun applyStyLing(timePickerDialog: TimePicker) {
        val system = Resources.getSystem()
        val hourNumberPickerId = system.getIdentifier("hour", "id", "android")
        val minuteNumberPickerId = system.getIdentifier("minute", "id", "android")
        val ampmNumberPickerId = system.getIdentifier("amPm", "id", "android")

        val hourNumberPicker = timePickerDialog.findViewById<NumberPicker>(hourNumberPickerId)
        val minuteNumberPicker = timePickerDialog.findViewById<NumberPicker>(minuteNumberPickerId)
        val ampmNumberPicker = timePickerDialog.findViewById<NumberPicker>(ampmNumberPickerId)

        setNumberPickerDividerColour(hourNumberPicker)
        setNumberPickerDividerColour(minuteNumberPicker)
        setNumberPickerDividerColour(ampmNumberPicker)
        setNumberpickerTextColour(hourNumberPicker)
        setNumberpickerTextColour(minuteNumberPicker)
        setNumberpickerTextColour(ampmNumberPicker)

    }

    private fun setNumberpickerTextColour(number_picker: NumberPicker) {
        val count = number_picker.childCount
        val color = context.resources.getColor(R.color.colorBlue)

        for (i in 0 until count) {
            val child = number_picker.getChildAt(i)

            try {
                val wheelpaintField =
                    number_picker.javaClass.getDeclaredField("mSelectorWheelPaint")
                wheelpaintField.isAccessible = true

                (wheelpaintField.get(number_picker) as Paint).color = color
                (child as EditText).setTextColor(color)
                number_picker.invalidate()
            } catch (e: NoSuchFieldException) {
                Log.w("AMBE1203", e)
            } catch (e: IllegalAccessException) {
                Log.w("AMBE1203", e)
            } catch (e: IllegalArgumentException) {
                Log.w("AMBE1203", e)
            }

        }
    }

    private fun setNumberPickerDividerColour(number_picker: NumberPicker) {
        val count = number_picker.childCount

        for (i in 0 until count) {

            try {
                val dividerField = number_picker.javaClass.getDeclaredField("mSelectionDivider")
                dividerField.isAccessible = true
                val colorDrawable = ColorDrawable(
                    context.resources.getColor(
                        R.color
                            .colorBlue
                    )
                )
                dividerField.set(number_picker, colorDrawable)

                number_picker.invalidate()
            } catch (e: NoSuchFieldException) {
                Log.w("setNumberPickerTxtClr", e)
            } catch (e: IllegalAccessException) {
                Log.w("setNumberPickerTxtClr", e)
            } catch (e: IllegalArgumentException) {
                Log.w("setNumberPickerTxtClr", e)
            }

        }
    }

    interface IOnAlertDialogListener : IOnSimpleDialogListener

}