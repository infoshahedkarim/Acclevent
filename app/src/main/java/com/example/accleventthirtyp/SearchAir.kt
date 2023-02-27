package com.example.accleventthirtyp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.accleventthirtyp.databinding.ActivitySearchAirBinding

class SearchAir : AppCompatActivity() {
    private lateinit var binding: ActivitySearchAirBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySearchAirBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.emirates.setOnClickListener {
            val msg = "https://www.emirates.com/BD/english/book/?gclid=Cj0KCQjwguGYBhDRARIsAHgRm4_5qBm1o6QWsgEC3Q3CHHSyZDwwswc6-N4cFkNCoqW04-VfZ8Mph6YaAh_WEALw_wcB&gclsrc=aw.ds"
            val intent = Intent(this, Browser::class.java).also {
                it.putExtra("message", msg)
                startActivity(it)
            }

        }
        binding.BimanBangla.setOnClickListener {
            val msg = "https://www.biman-airlines.com/"
            val intent = Intent(this, Browser::class.java).also {
                it.putExtra("message", msg)
                startActivity(it)
            }

        }

        binding.usbang.setOnClickListener {
            val msg = "https://usbair.com/"
            val intent = Intent(this, Browser::class.java).also {
                it.putExtra("message", msg)
                startActivity(it)
            }
        }
        binding.saa.setOnClickListener {
            val msg = "https://www.southasian-airlines.com/index.html"
            val intent = Intent(this, Browser::class.java).also {
                it.putExtra("message", msg)
                startActivity(it)
            }
        }
        binding.quter.setOnClickListener {
            val msg = "https://www.qatarairways.com/en-bd/homepage.html?CID=SXBD23457018M&account=Google-SEA_SASC-BD-EN-Brand&campaign=BD-Brand-Hero-EN_exact&adgroup=qatar+airways&term=qatar+airways&gclid=Cj0KCQjwguGYBhDRARIsAHgRm49AylV32qgfX5M8xOx3hYnQT9meZOH4DnB7VNwjMKP6vuYZuQuyl3EaAixfEALw_wcB&gclsrc=aw.ds"
            val intent = Intent(this, Browser::class.java).also {
                it.putExtra("message", msg)
                startActivity(it)
            }
        }
        binding.airindia.setOnClickListener {
            val msg = "https://www.momondo.com/flights/india?gclid=Cj0KCQjwguGYBhDRARIsAHgRm49iVawoJNm48pGKTTFUPneg3dLzB6xevElmIu1bSzvmaiJHFBFLIfQaAm-UEALw_wcB&aid=142851793569"
            val intent = Intent(this, Browser::class.java).also {
                it.putExtra("message", msg)
                startActivity(it)
            }
        }
        binding.flydubai.setOnClickListener {
            val msg = "https://www.flydubai.com/en/?tduid=a0b29e9d82bbf648c7d2de739e3326a3&utm_source=Mycashreturn&utm_medium=affiliate&utm_campaign=255518&utm_content=siteid-3278946_adid-22778008"
            val intent = Intent(this, Browser::class.java).also {
                it.putExtra("message", msg)
                startActivity(it)
            }
        }

    }
}