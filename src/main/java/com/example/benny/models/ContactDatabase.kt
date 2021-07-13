package com.example.benny.models

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.benny.models.Contact
import com.example.benny.models.ContactDao

@Database(entities = [Contact::class], version = 1)
abstract class ContactDatabase: RoomDatabase(){
    abstract fun contactDao() : ContactDao
}