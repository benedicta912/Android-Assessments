package com.example.benny.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Contact(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val firstname: String,
   // val lastname: String,
    val phonenumber: String,
   // val thumbNail: Int
)

