package com.dicoding.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val dataHero = intent.getParcelableExtra<Hero>("key_hero")!!

        val tvDetailName: TextView = findViewById(R.id.tv_detail_name)
        val tvDetailDescription: TextView = findViewById(R.id.tv_detail_description)
        val ivDetailPhoto: ImageView = findViewById(R.id.iv_detail_photo)
        val tvDetailAdditionalInfo: TextView = findViewById(R.id.tv_detail_additional_info)

        tvDetailName.text = dataHero.name
        tvDetailDescription.text = dataHero.description
        ivDetailPhoto.setImageResource(dataHero.photo)
        tvDetailAdditionalInfo.text = dataHero.additionalInfo

        val btnShare: Button = findViewById(R.id.btn_share)
        btnShare.setOnClickListener {
            shareHero(dataHero)
        }
    }

    private fun shareHero(hero: Hero) {
        val shareText = "Check out this hero: ${hero.name} - ${hero.description}"

        val sendIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, shareText)
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }

    fun onShareButtonClicked(view: android.view.View) {
        val dataHero = intent.getParcelableExtra<Hero>("key_hero")!!
        shareHero(dataHero)
    }
}