package com.evg_ivanoff.okolokursach

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.evg_ivanoff.okolokursach.databinding.RvItemContactBinding

class ContactAdapter: RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    private var dataList = listOf<Contact>()
    var onContactClickListener: OnContactClickListener? = null

    interface OnContactClickListener {
        fun onContactClick(contact: Contact)
        fun onContactLongClick(contact: Contact)
    }


    class ContactViewHolder(private val binding: RvItemContactBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(contact: Contact) {
            binding.apply {
                tvName.text = contact.name
                tvLastName.text = contact.lastName
                tvPhoneNumber.text = contact.phoneNumber
                imageContact.load(contact.imageUrl) {
                    crossfade(true)
                    transformations(CircleCropTransformation())
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ContactViewHolder(
        RvItemContactBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false)
    )

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.bind(dataList[position])
        holder.itemView.setOnClickListener {
            onContactClickListener?.onContactClick(dataList[position])
        }
        holder.itemView.setOnLongClickListener {
            onContactClickListener?.onContactLongClick(dataList[position])
            true
        }
    }

    override fun getItemCount() = dataList.size

    fun setContactList(contacts: List<Contact>) {
        dataList = contacts
        notifyDataSetChanged()
    }
}