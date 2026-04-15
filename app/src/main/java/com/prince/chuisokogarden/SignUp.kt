package com.prince.chuisokogarden

import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.loopj.android.http.RequestParams

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val undersignin=findViewById<TextView>(R.id.signin_link)

        undersignin.setOnClickListener {

            val undersigninIntent=Intent(this, SignIn::class.java)

            startActivity(undersigninIntent)

        }

//        find edit text buttons by id

        val username=findViewById<EditText>(R.id.username)
        val email=findViewById<EditText>(R.id.email)
        val phone=findViewById<EditText>(R.id.phone)
        val password=findViewById<EditText>(R.id.password)
        val signupbutton=findViewById<Button>(R.id.upbutton)

        signupbutton.setOnClickListener {

            val api= "https://jpmurage.alwaysdata.net/api/signup"

            val data= RequestParams()

            data.put("email",email.text.toString().trim())
            data.put("password",password.text.toString().trim())
            data.put("username",username.text.toString().trim())
            data.put("phone",phone.text.toString().trim())


//            Api Helper

            val helper= ApiHelper(applicationContext)
            helper.post(api,data)



        }





    }
}