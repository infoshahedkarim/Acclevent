package com.example.accleventthirtyp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.accleventthirtyp.databinding.ActivitySearchTrainBinding

class SearchTrain : AppCompatActivity() {
    private lateinit var binding: ActivitySearchTrainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchTrainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.train.setOnClickListener {
            val msg = "https://eticket.railway.gov.bd/"
            val intent = Intent(this, Browser::class.java).also {
                it.putExtra("message", msg)
                startActivity(it)
            }
        }
    }
}