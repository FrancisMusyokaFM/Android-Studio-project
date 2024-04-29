package com.example.allshoesshop

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.autofill.AutofillType
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.allshoesshop.databinding.ActivityStartingPageBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class StartingPage : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityStartingPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityStartingPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth

        binding.LogIn.setOnClickListener {

            val email = binding.email.text.toString()
            val  password = binding.password.text.toString()
            if(checkAlldetails()){
                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener{
                    if(it.isSuccessful){
                        val jay = Intent(this, MainActivity::class.java)
                         startActivity(jay)
                        Toast.makeText(this, "Logged in", Toast.LENGTH_SHORT).show()
                    }
                    else{
                        Log.e("error", it.exception.toString())
                    }
                }
            }

        }

    }


    private fun checkAlldetails():Boolean {
        val Email = binding.email.text.toString()
        if (binding.email.text.toString()== "") {
            binding.email.error = "Please input your email"
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
            binding.email.error = "Please input your email"
            return false
        }
        if (binding.password.text.toString() == "") {
            binding.password.error = "Please input your password"
            return false
        }
        if (binding.confirmpassword.text.toString() == "") {
            binding.confirmpassword.error = "Please confirm your password"
            return false
        }
        return true
    }
}


