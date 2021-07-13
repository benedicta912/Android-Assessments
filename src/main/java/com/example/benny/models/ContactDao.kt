package com.example.benny.models

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.benny.models.Contact

@Dao
interface ContactDao {
    @Query("SELECT * FROM contact")
    fun getAllContacts() : List<Contact>

    @Query("SELECT * FROM contact WHERE id = :id")
    fun getContactById(id: Int): Contact

    @Insert
    fun addContact(contact: Contact)

    @Delete
    fun deleteContact(contact: Contact)
}