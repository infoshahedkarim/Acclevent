package com.example.accleventthirtyp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.accleventthirtyp.databinding.ActivityForgetPassPageBinding
import com.google.firebase.auth.FirebaseAuth
class ForgetPassPage : AppCompatActivity() {

    private lateinit var binding: ActivityForgetPassPageBinding
    private lateinit var firebaseAuth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding=ActivityForgetPassPageBinding.inflate(layoutInflater)

        setContentView(binding.root)
       // firebaseAuth = FirebaseAuth.getInstance()
        binding.resetpass.setOnClickListener {
            val resetemail = binding.resetemail.text.toString()
            if(resetemail.isEmpty()){
                Toast.makeText(
                    this@ForgetPassPage,"Empty Fields Are not Allowed !!", Toast.LENGTH_SHORT).show()
            }
            else{
                FirebaseAuth.getInstance().sendPasswordResetEmail(resetemail)
                    .addOnCompleteListener { task ->
                        if(task.isSuccessful)
                        {
                            Toast.makeText(this@ForgetPassPage,"Email sent successfully to reset your password", Toast.LENGTH_SHORT ).show()
                            finish()
                        }
                        else{
                            Toast.makeText(this@ForgetPassPage,task.exception!!.message.toString(),Toast.LENGTH_SHORT).show()
                        }

                    }

            }
    }
}
}