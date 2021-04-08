package com.example.wonderfulindonesia

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity() {


    private lateinit var rvPlaces: RecyclerView
    private var list: ArrayList<Place> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val actionbar = supportActionBar
        actionbar!!.title= "Destination Places"

        rvPlaces = findViewById(R.id.rv_places)
        rvPlaces.setHasFixedSize(true)

        list.addAll(PlacesData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvPlaces.layoutManager = LinearLayoutManager(this)
        val placeAdapter = PlaceAdapter(list)
        rvPlaces.adapter = placeAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.ic_user -> {
                val MovetoAbout = Intent(this@HomeActivity, About::class.java)
                startActivity(MovetoAbout)
            }
        }
    }

}