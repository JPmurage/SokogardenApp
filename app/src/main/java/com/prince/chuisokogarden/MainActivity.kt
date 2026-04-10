package com.prince.chuisokogarden

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import  android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


//            Sign Up intent

            val signup =findViewById<Button>(R.id.signup)

            signup.setOnClickListener {

                val signupintent= Intent(this, SignUp::class.java)
                startActivity(signupintent)
            }

//            Sign In intent

        val signin=findViewById<Button>(R.id.signin)

            signin.setOnClickListener {

                val signinintent= Intent(this, SignIn::class.java)
                startActivity(signinintent)
            }




        }
    }
