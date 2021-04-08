package com.example.wonderfulindonesia

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class About : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        val actionbar = supportActionBar
        actionbar!!.title = "About"
        actionbar.setDisplayHomeAsUpEnabled(true)

        val imgUser: ImageView = findViewById(R.id.img_user)
        val tvUserName : TextView = findViewById(R.id.tv_username)
        val tvEmail : TextView = findViewById(R.id.tv_email)

        val tImg = "https://d17ivq9b7rppb3.cloudfront.net/small/avatar/20210308054154c5a7998369b590b18fe55fd9d22b1e8a.png"
        val userName = "Rochi Eko Pambudi"
        val Email = "Snowm6040@gmail.com"

        Glide.with(this)
            .load(tImg)
            .apply(RequestOptions())
            .into(imgUser)
        tvUserName.text = userName
        tvEmail.text = Email

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}