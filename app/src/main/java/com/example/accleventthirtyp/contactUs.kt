package com.example.accleventthirtyp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.GravityCompat
import com.example.accleventthirtyp.databinding.ActivityContactUsBinding
import com.example.accleventthirtyp.databinding.ActivitySearchAirBinding
import com.google.firebase.auth.FirebaseAuth

class contactUs : AppCompatActivity() {
    private lateinit var binding: ActivityContactUsBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityContactUsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()
        binding.navi.itemIconTintList = null
        binding.imgMenu.setOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }
        if(firebaseAuth.currentUser != null) {
            binding.navi.setNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.nav_home -> {
                        val intent = Intent(this, Dashboard::class.java)
                        startActivity(intent)
                    }
                    R.id.nav_bus -> {
                        val intent = Intent(this, SearchBus::class.java)
                        startActivity(intent)
                    }
                    R.id.nav_train -> {
                        val intent = Intent(this, SearchTrain::class.java)
                        startActivity(intent)
                    }
                    R.id.nav_launch -> {
                        val intent = Intent(this, SearchShip::class.java)
                        startActivity(intent)
                    }
                    R.id.nav_plane -> {
                        val intent = Intent(this, SearchAir::class.java)
                        startActivity(intent)
                    }
                    R.id.nav_terms -> {
                        val intent = Intent(this, TermsAndCo::class.java)
                        startActivity(intent)
                    }
                    R.id.nav_contact -> {
                        val intent = Intent(this, contactUs::class.java)
                        startActivity(intent)
                        Toast.makeText(this@contactUs, "current page selected", Toast.LENGTH_SHORT)
                            .show()
                    }
                    R.id.logout -> {
                        FirebaseAuth.getInstance().signOut()
                        val intent = Intent(this, HomePage::class.java)
                        startActivity(intent)
                    }
                }
                true
            }
        }else{
            Toast.makeText(this, "Login First!!", Toast.LENGTH_SHORT).show()
        }
        binding.terms.setOnClickListener {
            val msg = "https://www.facebook.com/info.shahedkarim"
            val intent = Intent(this, Browser::class.java).also {
                it.putExtra("message", msg)
                startActivity(it)
            }
        }
    }
}