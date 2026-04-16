package com.prince.chuisokogarden

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.loopj.android.http.RequestParams
import kotlin.concurrent.atomics.AtomicIntArray

class Payments : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_payments)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        Receive/Retrieve Extras Data the product_name and product_cost
//        This data is passed via Intent

        val productname= intent.getStringExtra("product_name")
        val product_cost=intent.getIntExtra("product_cost",0 )
        val productphoto=intent.getStringExtra("product_photo")
        val productdescription=intent.getStringExtra("product_description")




        val productdisplay=findViewById<ImageView>(R.id.productto)
        val productjina=findViewById<TextView>(R.id.productjina)
        val accountfigure=findViewById<TextView>(R.id.accountfigure)
        val  phonepay=findViewById<EditText>(R.id.phonepay)
        val purchase=findViewById<Button>(R.id.paybutton)
        val product_description=findViewById<TextView>(R.id.description)



//    Bind the id declaration with data passed

        productjina.text=productname
        accountfigure.text="Ksh  $product_cost"
        product_description.text=productdescription

        Glide.with(this)
            .load(productphoto)
            .into(productdisplay)



        purchase.setOnClickListener{

//            set API endpoint

            val api= "https:jpmurage.alwaysdata.net/api/mpesa_payment"

//            Created data using RequestParams, put phone and cost as keyvalue pairs

            val data= RequestParams()

            data.put("amount", product_cost)
            data.put("phone", phonepay.text.toString())
            data.put("description",product_description.text.toString())



            val helper= ApiHelper(applicationContext)

            helper.post(api,data)



        }









    }
}