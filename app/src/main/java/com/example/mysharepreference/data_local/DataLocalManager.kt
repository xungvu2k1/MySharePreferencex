package com.example.mysharepreference.data_local

import android.content.Context
import com.example.mysharepreference.models.User
import com.google.gson.Gson
import com.google.gson.JsonArray
import org.json.JSONArray
import org.json.JSONObject

class DataLocalManager {

    private lateinit var mySharedPreferences: MySharedPreferences

    companion object{
        val FREE_FIRST_INSTALL = "FREE_FIRST_INSTALL"
        private lateinit var instance : DataLocalManager

        fun init(context: Context){
            instance = DataLocalManager()
            instance.mySharedPreferences = MySharedPreferences(context)
        }
        fun getInstance(): DataLocalManager {
            if (instance == null){
                instance = DataLocalManager()
            }
            return instance
        }

        //-------------------------------------------------------------------------------------
        fun setNameUsers(nameUsers : Set<String>){
            getInstance().mySharedPreferences.putStringSetValue(FREE_FIRST_INSTALL, nameUsers)
        }

        fun getNameUsers(): MutableSet<String>? {
            return getInstance().mySharedPreferences.getStringSetValue(FREE_FIRST_INSTALL)
        }
        //-------------------------------------------------------------------------------------
        fun setUserObject(user: User){
            val gson : Gson = Gson()
            val stringGsonUser = gson.toJson(user) // chuyển object thành dạng string Gson
            getInstance().mySharedPreferences.putStringValue("keyUserObject", stringGsonUser)
        }

        fun getUserObject(): User{
            // get String
            val stringGsonUser = getInstance().mySharedPreferences.getStringValue(
                "keyUserObject"
            )
            // convert stringGson into User object
            val gson : Gson = Gson()
            val user : User = gson.fromJson(stringGsonUser, User::class.java)
            return user
        }
        //-------------------------------------------------------------------------------------
        fun setUserObjectList (userList : MutableList<User>) {
            //chuyen userList thanh dang jsonArray => jsonArrayString
            val gson = Gson()
            val jsonArray : JsonArray = gson.toJsonTree(userList).asJsonArray
            val strJsonArray : String = jsonArray.toString()
            getInstance().mySharedPreferences.putStringValue("keyUserObjectList", strJsonArray)
        }

        fun getUserObjectList() : MutableList<User>{
            val userObjectListString : String? = getInstance().mySharedPreferences.getStringValue("keyUserObjectList")
            val userList = mutableListOf<User>()
            val gson = Gson()
            val jsonUserArray : JSONArray = JSONArray(userObjectListString)
            for (i in 0..<jsonUserArray.length()){
                val jsonUserObject = jsonUserArray.getJSONObject(i)
                val userStr = gson.fromJson(jsonUserObject.toString(), User::class.java)
                userList.add(userStr)
            }
            return userList
        }
    }

}