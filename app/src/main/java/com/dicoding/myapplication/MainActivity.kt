package com.dicoding.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: HeroAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = HeroAdapter(this, getHeroList()) { hero -> onItemClicked(hero) }
        recyclerView.adapter = adapter
    }

    private fun onItemClicked(hero: Hero) {
        val intentDetail = Intent(this, DetailActivity::class.java)
        intentDetail.putExtra("key_hero", hero)
        startActivity(intentDetail)
    }

    private fun getHeroList(): List<Hero> {
        return Hero.HEROES
    }

    fun openAboutPage(view: View) {
        val intentAbout = Intent(this, AboutActivity::class.java)
        startActivity(intentAbout)
    }
}