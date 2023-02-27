package com.example.accleventthirtyp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.accleventthirtyp.databinding.ActivitySearchBusBinding

class SearchBus : AppCompatActivity() {

    private lateinit var binding: ActivitySearchBusBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBusBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.shohoz.setOnClickListener {
            val msg = "https://www.shohoz.com/bus-tickets"
            val intent = Intent(this, Browser::class.java).also {
                it.putExtra("message", msg)
                startActivity(it)
            }

        }
        binding.busbd.setOnClickListener {
            val msg = "https://busbd.com.bd/"
            val intent = Intent(this, Browser::class.java).also {
                it.putExtra("message", msg)
                startActivity(it)
            }

        }

        binding.sb.setOnClickListener {
            val msg = "https://sbsuperdeluxe.com/"
            val intent = Intent(this, Browser::class.java).also {
                it.putExtra("message", msg)
                startActivity(it)
            }
        }
        binding.hanif.setOnClickListener {
            val msg = "https://www.hanifenterprise.com/"
            val intent = Intent(this, Browser::class.java).also {
                it.putExtra("message", msg)
                startActivity(it)
            }
        }
        binding.shohag.setOnClickListener {
            val msg = "https://shohagh.com/"
            val intent = Intent(this, Browser::class.java).also {
                it.putExtra("message", msg)
                startActivity(it)
            }
        }
        binding.shymoli.setOnClickListener {
            val msg = "https://shyamolitickets.com/"
            val intent = Intent(this, Browser::class.java).also {
                it.putExtra("message", msg)
                startActivity(it)
            }
        }
        binding.greenline.setOnClickListener {
            val msg = "https://greenlinebd.com/"
            val intent = Intent(this, Browser::class.java).also {
                it.putExtra("message", msg)
                startActivity(it)
            }
        }
        binding.grameen.setOnClickListener {
            val msg = "https://www.grameentravelsbd.com/"
            val intent = Intent(this, Browser::class.java).also {
                it.putExtra("message", msg)
                startActivity(it)
            }
        }

        binding.trtravel.setOnClickListener {
            val msg = "https://newtrtravels.com/"
            val intent = Intent(this, Browser::class.java).also {
                it.putExtra("message", msg)
                startActivity(it)
            }
        }


    }
}