package com.example.benny.models

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.benny.databinding.ContactItemBinding

class ContactAdapter(var contacts: List<Contact>, val clicker: (Contact) -> Unit) :
    RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {
    inner class ContactViewHolder(private val binding: ContactItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindContact(contact: Contact) {
            binding.apply {
                nameTextview.text = contact.id.toString()
                phoneNumberTextview.text = contact.firstname
                root.setOnClickListener { clicker(contact) }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val binding = ContactItemBinding.inflate(LayoutInflater.from(parent.context))
        return ContactViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
       holder.bindContact((contacts[position]))
    }

    override fun getItemCount(): Int {
        return contacts.size
    }
}