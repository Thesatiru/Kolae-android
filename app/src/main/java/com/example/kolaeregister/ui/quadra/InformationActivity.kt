package com.example.kolaeregister.ui.quadra

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.kolaeregister.R
import com.example.kolaeregister.data.model.Venue

class InformationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_infomacao)




        val venue = intent.getSerializableExtra("EXTRA_QUADRA") as? Venue

        val btnBack = findViewById<ImageView>(R.id.btnBack)
        btnBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }


        venue?.let {
            val txtTitle = findViewById<TextView>(R.id.txtVenueTitle)
            val txtSubTitle = findViewById<TextView>(R.id.txtVenueSubtitle)
            val txtDescription = findViewById<TextView>(R.id.txtVenueDescription)
            val imgVenue = findViewById<ImageView>(R.id.imgVenueDetail)
            val txtVenuePrice = findViewById<TextView>(R.id.txtVenuePrice)
            val txtVenueRating = findViewById<TextView>(R.id.txtVenueRating)
            val txtVenueNumberRatings = findViewById<TextView>(R.id.txtVenueNumberRatings)
            val txtVenueLocation = findViewById<TextView>(R.id.txtVenueLocation)

            val imgOwner = findViewById<ImageView>(R.id.imgOwnerProfile)
            val txtOwnerName = findViewById<TextView>(R.id.txtOwnerName)
            val txtMonthsOnApp = findViewById<TextView>(R.id.txtMonthsOnApp)

            txtTitle.text = it.name
            txtSubTitle.text = it.subtitle
            txtDescription.text = it.description
            txtVenueLocation.text = it.location
            txtVenueRating.text = it.rating.toString()
            txtVenueNumberRatings.text = "${it.numberRatings} avaliações"
            txtOwnerName.text = it.owner
            txtMonthsOnApp.text = "Membro há ${it.monthsOnApp} meses"

            txtVenuePrice.text = if (it.pricePerHour != null){
                "R$ ${it.pricePerHour}/h"
            } else {
                "Preço sob consulta"
            }

            // Foto principal da quadra
            Glide.with(this)
                .load(it.imageUrl)
                .placeholder(android.R.drawable.ic_menu_gallery)
                .error(android.R.drawable.ic_menu_report_image)
                .into(imgVenue)

            Glide.with(this)
                .load(it.imgOwnerUrl)
                .placeholder(android.R.drawable.ic_menu_gallery)
                .error(android.R.drawable.ic_menu_report_image)
                .circleCrop()
                .into(imgOwner)
        }
    }
}