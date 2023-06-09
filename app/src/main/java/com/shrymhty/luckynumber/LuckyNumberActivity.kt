package com.shrymhty.luckynumber

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class LuckyNumberActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lucky_number)

        val text1 : TextView = findViewById(R.id.text1)
        val text2 : TextView = findViewById(R.id.text2)
        val b2 : Button = findViewById(R.id.btn2)
        var rand = randomNumgenerator()
        var user_name = receiveUserName()
        text2.setText(""+rand)

        b2.setOnClickListener {
            shareData(user_name, rand)

        }
    }

    fun receiveUserName():String{
        var bundle: Bundle? = intent.extras
        var username = bundle?.get("name").toString()
        return username
    }

    fun randomNumgenerator() : Int {
        val random = Random.nextInt(1000)
        return random
    }

    fun shareData(username: String, num : Int) {
        var i = Intent(Intent.ACTION_SEND)
        i.setType("text/plain")
        i.putExtra(Intent.EXTRA_SUBJECT, "$username is lucky today!!")
        i.putExtra(Intent.EXTRA_TEXT, "Their lucky number is $num")
        startActivity(i)
    }
}