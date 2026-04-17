package com.prince.chuisokogarden

import android.content.Intent
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Locale

class About : AppCompatActivity() {

//    Declare a tts variable

    lateinit var tts: TextToSpeech
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_about)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val aboutdescription= findViewById<TextView>(R.id.textview)

        val speak= findViewById<EditText>(R.id.inputText)

        val listenbutton= findViewById<Button>(R.id.speakButton)

//            Initialize text to speech

        tts= TextToSpeech(this){

//            check if the speech is successful

            if(it== TextToSpeech.SUCCESS){

                tts.language=Locale.JAPANESE
            }

        }



//        Set button listener

        listenbutton.setOnClickListener {

            val texxt=aboutdescription.text.toString()
            tts.speak(texxt, TextToSpeech.QUEUE_FLUSH,null,null)

        }

        }


//    Stop the tts from speaking when the app is closed /destroyed/ killed
    override fun onDestroy() {

        tts.stop()//stops tts
        tts.shutdown()

        super.onDestroy()
    }




    }
