package com.example.benny.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.benny.databinding.ActivityContactBinding
import com.example.benny.databinding.ActivityMainBinding

class ContactActivity : AppCompatActivity() {

    private lateinit var binding: ActivityContactBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.run {
            nameDisplay.text = intent.getIntExtra("id", 0).toString()
            phonenumberDisplay.text = intent.getStringExtra("firstname").toString()
            emailDisplay.text = intent.getStringExtra("phonenumber").toString()
        }
    }
}