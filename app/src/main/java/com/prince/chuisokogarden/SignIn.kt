package com.prince.chuisokogarden

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import  android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.loopj.android.http.RequestParams

class SignIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_in)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets






//            https://jpmurage.alwaysdata.net/api/signin
//            https://jpmurage.alwaysdata.net/api/signup
//            https://jpmurage.alwaysdata.net/api/getproductdetails
//            https:jpmurage.alwaysdata.net/api/mpesa_payment


        }
        val undersignup=findViewById<TextView>(R.id.signup_link)

        undersignup.setOnClickListener {

            val undersignupintent= Intent(this, SignUp::class.java)
            startActivity(undersignupintent)

        }


//        find the edittext buttons by id

        val email=findViewById<EditText>(R.id.email)
        val password=findViewById<EditText>(R.id.password)
        val signinbutton=findViewById<Button>(R.id.signinbutton)
        signinbutton.setOnClickListener {

            val api="https://jpmurage.alwaysdata.net/api/signin"

//            Request params is the container used to collect the user details its like form data in js
            val data= RequestParams()

            data.put("email",email.text.toString().trim())
            data.put("password",password.text.toString().trim())

//            Api helper- it delivers our data to the api

            val helper= ApiHelper(applicationContext)
            helper.post_login(api,data)

        }


    }
}