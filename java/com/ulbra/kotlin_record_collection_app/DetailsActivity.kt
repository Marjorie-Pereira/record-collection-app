package com.ulbra.kotlin_record_collection_app


import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ulbra.kotlin_record_collection_app.data.model.Album

class DetailsActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val title = findViewById<TextView>(R.id.albumTitle)
        val artistName = findViewById<TextView>(R.id.artistName)
        val year = findViewById<TextView>(R.id.year)
        val price = findViewById<TextView>(R.id.price)
        val genre = findViewById<TextView>(R.id.genre)
        val image = findViewById<ImageView>(R.id.albumCover)

        intent.extras?.getSerializable("album", Album::class.java).also {
            it?.let {
                title.text = it.title
                artistName.text = it.artist
                year.text = it.year
                genre.text = it.genre
                price.text = it.price.toString()
                image.setImageResource(it.cover)
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}