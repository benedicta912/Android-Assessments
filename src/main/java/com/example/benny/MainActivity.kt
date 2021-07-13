package com.example.benny

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.benny.activities.ContactDetailsActivity
import com.example.benny.databinding.ActivityMainBinding
import com.example.benny.models.Contact
import com.example.benny.models.ContactAdapter
import com.example.benny.models.ContactDatabase
import com.example.benny.viewmodels.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var contactAdapter: ContactAdapter
    private lateinit var database: ContactDatabase
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = Room.databaseBuilder(
            applicationContext, ContactDatabase::class.java, "contacts_database"
        ).allowMainThreadQueries().build()

        viewModel =  ViewModelProvider(this) [MainActivityViewModel::class.java]
        viewModel.getContacts(database)

        contactAdapter = ContactAdapter(listOf<Contact>()){
            val intent = Intent(this@MainActivity, ContactDetailsActivity::class.java)
            intent.run{
                putExtra("id", it.id)
                putExtra("firstname", it.firstname)
                putExtra("phonenumber", it.phonenumber)
            }
            Log.d("MAIN", "view clicked")
            startActivity(intent)
        }
        binding.contactRecyclerview.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = contactAdapter
        }
        viewModel.contactsLiveData.observe(this, { contacts ->
            contactAdapter.contacts = contacts
            contactAdapter.notifyDataSetChanged()
        })

        binding.saveButtonId.setOnClickListener {
            val firstname = binding.nameText.text.toString()
            val phonenumber = binding.phonenumberText.text.toString()

            saveContact(firstname, phonenumber)
        }
    }

    private fun saveContact(firstname: String, phonenumber: String){
        val contact = Contact(id = 0, firstname, phonenumber)
        database.contactDao().addContact(contact)
        viewModel.addContact(database, contact)
    }
}