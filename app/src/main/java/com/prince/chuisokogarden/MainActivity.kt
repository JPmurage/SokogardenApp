package com.prince.chuisokogarden

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import  android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

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



//        About button intent

                val about= findViewById<Button>(R.id.aboutbtn)

                about.setOnClickListener {

                    val aboutIntent= Intent(this,About::class.java)
                    startActivity(aboutIntent)
                    finish()
                }

//        speech to text intent

        val speechtotext= findViewById<Button>(R.id.speechtotext)

        speechtotext.setOnClickListener {

            val speechtotextintent= Intent(this, SpeechToTextActivity::class.java)
            startActivity(speechtotextintent)
            finish()

        }


//            Sign In intent

//             val signin=findViewById<Button>(R.id.signin)
//
//            signin.setOnClickListener {
//
//                val signinintent= Intent(this, SignIn::class.java)
//                startActivity(signinintent)
//            }

            val progressbar=findViewById<ProgressBar>(R.id.progressbar)
            val recyclerView=findViewById<RecyclerView>(R.id.recyvlerView)

            val api="https://jpmurage.alwaysdata.net/api/getproductdetails"

            val helper= ApiHelper(applicationContext)
        helper.loadProducts(api,recyclerView,progressbar)



        }
    }
