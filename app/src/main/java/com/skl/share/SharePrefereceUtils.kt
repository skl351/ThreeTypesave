package com.skl.share

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by MaiBenBen on 2018/12/29.
 */
object SharePrefereceUtils {
    val APP_CACHE_NAME = "myskl"
    var mSharedPreferences: SharedPreferences? = null
    fun init(context: Context) {
        if (mSharedPreferences == null && context != null) {
            mSharedPreferences = context.getSharedPreferences(APP_CACHE_NAME, Context.MODE_PRIVATE)
        }
    }

    private fun getSP(): SharedPreferences? {
        return mSharedPreferences
    }

    private fun getEditor(): SharedPreferences.Editor? {
        return getSP()?.edit()
    }

    fun save(key: String, value: Boolean) {
        getEditor()?.putBoolean(key, value)?.apply()
    }

    fun save(key: String, value: Int) {
        getEditor()?.putInt(key, value)?.apply()
    }

    fun save(key: String, value: Float) {
        getEditor()?.putFloat(key, value)?.apply()
    }

    fun save(key: String, value: Long) {
        getEditor()?.putLong(key, value)?.apply()
    }

    fun save(key: String, value: String) {
        getEditor()?.putString(key, value)?.apply()
    }

    fun save(key: String, value: Set<String>) {
        getEditor()?.putStringSet(key, value)?.apply()
    }

    fun getBoolean(key: String, defValue: Boolean): Boolean? {
        return getSP()?.getBoolean(key, defValue)
    }

    fun getString(key: String, defValue: String): String? {
        return getSP()?.getString(key, defValue)
    }

    fun getInt(key: String, defValue: Int): Int? {
        return getSP()?.getInt(key, defValue)
    }

    fun getFloat(key: String, defValue: Float): Float? {
        return getSP()?.getFloat(key, defValue)
    }

    fun getLong(key: String, defValue: Long): Long? {
        return getSP()?.getLong(key, defValue)
    }

    fun getStringSet(key: String, defValue: Set<String>): Set<String>? {
        return getSP()?.getStringSet(key, defValue)
    }

    fun contains(key: String): Boolean? {
        return getSP()?.contains(key)
    }

    fun clearAll() {

        getEditor()?.clear()?.apply()
    }

    fun delete(str: String) {
        getEditor()?.remove(str)?.apply()
    }

    fun getAll() :String{
      var map=  (getSP()?.all )as Map<String,*>
        var str=""
        for (m1 in map){
            str+=""+m1.key+":"+m1.value+"---"
        }
        return str
    }
}