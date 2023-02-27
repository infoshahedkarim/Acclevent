package com.example.accleventthirtyp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.accleventthirtyp.databinding.ActivitySearchShipBinding

class SearchShip : AppCompatActivity() {
    private lateinit var binding: ActivitySearchShipBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchShipBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.launch.setOnClickListener {
            val msg = "https://www.shohoz.com/launch/"
            val intent = Intent(this, Browser::class.java).also {
                it.putExtra("message", msg)
                startActivity(it)
            }
        }

    }
}