package com.example.mysharepreference

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.mysharepreference.data_local.DataLocalManager
import com.example.mysharepreference.models.User

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val tvInfor = findViewById<TextView>(R.id.tv_infor)
        val userStringInfors : MutableSet<String>? = DataLocalManager.getNameUsers()
        val userObjectInfor : User = DataLocalManager.getUserObject()
        val userObjectList : MutableList<User> = DataLocalManager.getUserObjectList()

        tvInfor.text = userStringInfors.toString() + "\n"+userObjectInfor.toString() +
                    "\n" + userObjectList.toString()
    }
}