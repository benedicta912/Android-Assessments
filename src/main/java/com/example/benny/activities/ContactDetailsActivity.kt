package com.example.benny.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.benny.databinding.ActivityContactDetailsBinding

class ContactDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityContactDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.run {
            newContact2.text = intent.getIntExtra("id", 0).toString()
            contactName2.text = intent.getStringExtra("firstname").toString()
            phoneNumbers.text = intent.getStringExtra("phonenumber").toString()
        }
    }
}

