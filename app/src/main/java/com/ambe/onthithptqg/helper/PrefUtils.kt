package com.ambe.onthithptqg.helper

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

/**
 *  Created by AMBE on 22/7/2019 at 14:07 PM.
 */
class PrefUtils {

    private var pref: SharedPreferences? = null

    private constructor(context: Context?) {
        pref = PreferenceManager.getDefaultSharedPreferences(context?.applicationContext)
    }

    companion object {
        private var instance: PrefUtils? = null
        fun getInstance(context: Context?): PrefUtils {
            if (instance == null) instance = PrefUtils(context?.applicationContext)

            return instance!!
        }
    }

    fun putBoolean(key: String, value: Boolean) {
        pref?.apply {
            val editor = this.edit()
            editor.putBoolean(key, value)
            editor.apply()
        }
    }

    fun getBoolean(key: String, defaultValue: Boolean): Boolean? {
        return pref?.getBoolean(key, defaultValue)
    }


    fun putString(key: String, value: String) {
        pref?.apply {
            val editor = this.edit()
            editor.putString(key, value)
            editor.apply()
        }
    }

    fun getString(key: String, defaultValue: String): String? {
        return pref?.getString(key, defaultValue)
    }

    fun putInt(key: String, value: Int) {
        pref?.apply {
            val editor = this.edit()
            editor.putInt(key, value)
            editor.apply()
        }
    }

    fun getInt(key: String, defaultValue: Int): Int? {
        return pref?.getInt(key, defaultValue)
    }
}