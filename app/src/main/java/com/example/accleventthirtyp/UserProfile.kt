package com.example.accleventthirtyp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.accleventthirtyp.databinding.ActivityUserProfileBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlin.system.exitProcess

class UserProfile : AppCompatActivity() {

    private lateinit var binding: ActivityUserProfileBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUserProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()

        //----> logout code// binding.logout.setOnClickListener {

        // FirebaseAuth.getInstance().signOut()
        // val intent = Intent(this, HomePage::class.java)
        // startActivity(intent)
        // }
        binding.adddata.setOnClickListener {

            val firstName = binding.firstname.text.toString()
            val lastName = binding.lastname.text.toString()
            val contactno = binding.contactno.text.toString()
            val emailno = binding.emailno.text.toString()
            val message = intent.getStringExtra(" ")


            if (firstName.isNotEmpty() && lastName.isNotEmpty() && contactno.isNotEmpty() && emailno.isNotEmpty()) {
                if (contactno.length == 11) {


                    if(message==emailno){

                        database = FirebaseDatabase.getInstance()
                            .getReference("Users") // defines the db location
                        val userinput =
                            userinput(firstName, lastName, contactno,emailno) // creates object of user
                        database.child(contactno).setValue(userinput).addOnSuccessListener {

                            binding.firstname.text!!.clear()// clears previous text
                            binding.lastname.text!!.clear()
                            binding.contactno.text!!.clear()
                            binding.emailno.text!!.clear()

                            val intent = Intent(this, Dashboard::class.java)
                            startActivity(intent)


                            Toast.makeText(this, "Welcome to Accelevent.Book your way", Toast.LENGTH_SHORT).show()


                        }.addOnFailureListener{
                            Toast.makeText(this,"Failed!!! Try again",Toast.LENGTH_SHORT).show() // on fail shows
                        }

                    }else{
                        Toast.makeText(this, "Please enter the same email address", Toast.LENGTH_SHORT).show()

                    }




                }



                else{
                    Toast.makeText(this, "Contact no must be 11 digit. Please try again", Toast.LENGTH_SHORT).show()
                }

            }
            else{
                Toast.makeText(this, "Empty field is not allowed!!", Toast.LENGTH_SHORT).show()
            }
        }
    }


    override fun onBackPressed() {
        super.onBackPressed()

        }

}

