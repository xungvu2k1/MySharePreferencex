package com.example.mysharepreference.data_local

import android.content.Context
import android.content.SharedPreferences

class MySharedPreferences (val mContext : Context){
    companion object{
        val My_Shared_Preferences : String = "MySharedPreferences"
    }

    fun putBooleanValue(key: String, value: Boolean){
        val sharedPreferences : SharedPreferences = mContext.getSharedPreferences(
            My_Shared_Preferences,
            Context.MODE_PRIVATE)
        val editor : SharedPreferences.Editor = sharedPreferences.edit()
        editor.putBoolean(key, value)
        editor.apply()
    }

    fun getBooleanValue(key : String): Boolean {
        val sharedPreferences : SharedPreferences = mContext.getSharedPreferences(
            My_Shared_Preferences,
            Context.MODE_PRIVATE)
        return sharedPreferences.getBoolean(key, false)
    }

    fun putStringValue(key: String, value: String){
        val sharedPreferences : SharedPreferences = mContext.getSharedPreferences(
            My_Shared_Preferences,
            Context.MODE_PRIVATE)
        val editor : SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun getStringValue(key : String): String? {
        val sharedPreferences : SharedPreferences = mContext.getSharedPreferences(
            My_Shared_Preferences,
            Context.MODE_PRIVATE)
        return sharedPreferences.getString(key, "")
    }

    fun putStringSetValue(key: String, values: Set<String>){
        val sharedPreferences : SharedPreferences = mContext.getSharedPreferences(
            My_Shared_Preferences,
            Context.MODE_PRIVATE)
        val editor : SharedPreferences.Editor = sharedPreferences.edit()
        editor.putStringSet(key, values)
        editor.apply()
    }

    fun getStringSetValue(key : String): MutableSet<String>? {
        val sharedPreferences : SharedPreferences = mContext.getSharedPreferences(
            My_Shared_Preferences,
            Context.MODE_PRIVATE)
        val valueDefault : Set<String> = HashSet()
        return sharedPreferences.getStringSet(key, valueDefault)
    }

}