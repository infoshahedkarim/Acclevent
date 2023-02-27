package com.example.accleventthirtyp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.accleventthirtyp.databinding.ActivityDashboardBinding
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth

class Dashboard : AppCompatActivity() {

    private  lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

       // val drawarLayout = findViewById<DrawerLayout>(R.id.drawerLayout)
       // val imgMenu = findViewById<ImageView>(R.id.imgMenu)


       // val navView = findViewById<NavigationView>(R.id.navi)

        binding.navi.itemIconTintList = null
        binding.imgMenu.setOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }
        binding.navi.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_home -> {
                    val intent = Intent(this, Dashboard::class.java)
                    startActivity(intent)
                    Toast.makeText(this@Dashboard,"current page selected", Toast.LENGTH_SHORT ).show()
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
                }
                R.id.logout -> {
                    FirebaseAuth.getInstance().signOut()
                    val intent = Intent(this, HomePage::class.java)
                    startActivity(intent)
                }
            }
            true
        }
        binding.searchbus.setOnClickListener {
            val intent = Intent(this, SearchBus::class.java)
            startActivity(intent)

        }
        binding.searchplane.setOnClickListener {
            val intent = Intent(this, SearchAir::class.java)
            startActivity(intent)

        }
        binding.searchship.setOnClickListener {
            val intent = Intent(this, SearchShip::class.java)
            startActivity(intent)

        }
        binding.searchtrain.setOnClickListener {
            val intent = Intent(this, SearchTrain::class.java)
            startActivity(intent)

        }


    }
}

