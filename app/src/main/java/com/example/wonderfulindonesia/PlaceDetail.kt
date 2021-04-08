package com.example.wonderfulindonesia

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class PlaceDetail  : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_place)
        val actionbar = supportActionBar
        actionbar!!.title = "Detail Tempat"
        actionbar.setDisplayHomeAsUpEnabled(true)

        val tvSetPlace: TextView = findViewById(R.id.tv_set_name)
        val imgSetPhoto: ImageView = findViewById(R.id.img_item_photo)
        val tvSetOver: TextView = findViewById(R.id.tv_set_detail)
        val tvDesc: TextView = findViewById(R.id.tv_set_description)
        val tvRate: TextView = findViewById(R.id.tv_item_rate)

        val tPlace  = intent.getStringExtra(EXTRA_PLACE)
        val tImg = intent.getStringExtra(EXTRA_PHOTO)
        val tIDesc = intent.getStringExtra(EXTRA_DESC)
        val tOverview = intent.getStringExtra(EXTRA_OVERVIEW)
        val tRate = intent.getStringExtra(EXTRA_RATE)

        tvSetPlace.text = tPlace
        Glide.with(this)
            .load(tImg)
            .apply(RequestOptions())
            .into(imgSetPhoto)
        tvDesc.text = tIDesc
        tvSetOver.text = tOverview
        tvRate.text = tRate
    }

    companion object {
        const val EXTRA_PLACE = "extra_place"
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_DESC = "extra_desc"
        const val EXTRA_OVERVIEW = "extra_overview"
        const val EXTRA_RATE = "extra_rate"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}