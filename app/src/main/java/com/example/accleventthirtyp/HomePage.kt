package com.example.accleventthirtyp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout

import com.example.accleventthirtyp.databinding.ActivityHomePageBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.android.material.navigation.NavigationView
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth


class HomePage : AppCompatActivity() {


    private lateinit var binding: ActivityHomePageBinding
    private lateinit var topAnimation: Animation
    private lateinit var bottomAnimation: Animation
    lateinit var mGoogleSignInClient: GoogleSignInClient
    val Req_Code: Int = 123
    private lateinit var firebaseAuth: FirebaseAuth



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // binding = HomePage()
        binding=ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //val drawarLayout = findViewById<DrawerLayout>(R.id.drawerLayout)
        //val imgMenu = findViewById<ImageView>(R.id.imgMenu)

       // val navView = findViewById<NavigationView>(R.id.navi)
       // navView.itemIconTintList = null
        binding.navi.itemIconTintList = null
        binding.imgMenu.setOnClickListener{
       // imgMenu.setOnClickListener {
           // drawarLayout.openDrawer(GravityCompat.START)
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }
       // navView.setNavigationItemSelectedListener {
        binding.navi.setNavigationItemSelectedListener {
            when(it.itemId){

                R.id.nav_terms -> {
                    val intent = Intent(this, TermsAndCo::class.java)
                    startActivity(intent)
                }
                R.id.nav_contact -> {
                    val intent = Intent(this, contactUs::class.java)
                    startActivity(intent)
                }

            }
            true

        }

        topAnimation= AnimationUtils.loadAnimation(this, R.anim.top_animation)
        bottomAnimation= AnimationUtils.loadAnimation(this, R.anim.bottom_animation)

        binding.loginpage.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
        binding.capage.setOnClickListener {
            val intent = Intent(this, Createaccount::class.java)
            startActivity(intent)
        }
        binding.imageView2.animation=topAnimation
        binding.imageView3.animation=bottomAnimation
        FirebaseApp.initializeApp(this)

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)
        firebaseAuth = FirebaseAuth.getInstance()

       binding.signn.setOnClickListener { view: View? ->
            Toast.makeText(this, "Logging In", Toast.LENGTH_SHORT).show()
            signInGoogle()
        }
    }

    private fun signInGoogle() {
        val signInIntent: Intent = mGoogleSignInClient.signInIntent
        startActivityForResult(signInIntent, Req_Code)
    }

    // onActivityResult() function : this is where
    // we provide the task and data for the Google Account
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == Req_Code) {
            val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleResult(task)
        }
    }

    private fun handleResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account: GoogleSignInAccount? = completedTask.getResult(ApiException::class.java)
            if (account != null) {
              //  UpdateUI(account)
                val intent = Intent(this, Dashboard::class.java)
                        startActivity(intent)
                         finish()
            }
        } catch (e: ApiException) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    // this is where we update the UI after Google signin takes place
   // private fun UpdateUI(account: GoogleSignInAccount) {
      //  val credential = GoogleAuthProvider.getCredential(account.idToken, null)
     //   firebaseAuth.signInWithCredential(credential).addOnCompleteListener { task ->
         //   if (task.isSuccessful) {
           //     SavedPreference.setEmail(this, account.email.toString())
          //      SavedPreference.setUsername(this, account.displayName.toString())
         //       val intent = Intent(this, Dashboard::class.java)
       //         startActivity(intent)
       //         finish()
      //      }
      //  }
   // }

    override fun onStart() {
        super.onStart()
        if (GoogleSignIn.getLastSignedInAccount(this) != null) {
            startActivity(
                Intent(
                    this, Dashboard
                    ::class.java
                )
            )
            finish()
        }
    }
}







