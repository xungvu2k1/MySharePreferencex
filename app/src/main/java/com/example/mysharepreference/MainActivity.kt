package com.example.mysharepreference

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.mysharepreference.data_local.DataLocalManager
import com.example.mysharepreference.models.User

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DataLocalManager.init(applicationContext)

        val nameUsers : MutableSet<String> = HashSet()
        nameUsers.add("Xung")
        nameUsers.add("Truong")
        nameUsers.add("Nhan")
        DataLocalManager.setNameUsers(nameUsers)

        //lưu 1 object vào SharedPreference
        val user = User("Vu Van Xung", 22)
        DataLocalManager.setUserObject(user)

        // luu nhieu obj vao 1 list
        val user1 = User("Vu Van Nhan", 12)
        val user2 = User("Vu Van Dai", 19)
        val user3 = User("Vu Van Thanh", 21)
        val mutableList = mutableListOf<User>(user1, user2, user3)
        DataLocalManager.setUserObjectList(mutableList)


        findViewById<Button>(R.id.btn_next).setOnClickListener{
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }



    }
}