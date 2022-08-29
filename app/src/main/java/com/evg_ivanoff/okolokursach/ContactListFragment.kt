package com.evg_ivanoff.okolokursach

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.evg_ivanoff.okolokursach.databinding.FragmentContactListBinding

private const val ARG_PARAM1 = "name"
private const val ARG_PARAM2 = "lastName"
private const val ARG_PARAM3 = "phoneNumber"
private const val ARG_PARAM4 = "imageUrl"
private const val ARG_PARAM5 = "id"

class ContactListFragment : Fragment() {
    private var param_name: String? = null
    private var param_lastName: String? = null
    private var param_phoneNumber: String? = null
    private var param_imageUrl: String? = null
    private var param_landscape: Boolean = false
    private lateinit var binding: FragmentContactListBinding
    private val adapter = ContactAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param_landscape = it.getBoolean("ORI")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentContactListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        requireActivity().supportFragmentManager
//            .beginTransaction()
//            .add(R.id.contactListFrag, ContactListFragment())
//            .commit()

        rvInit()


        adapter.onContactClickListener = object : ContactAdapter.OnContactClickListener {
            override fun onContactClick(contact: Contact) {
                val fragment = newInstance(contact)
                when (param_landscape) {
                    false -> {
                        activity!!.supportFragmentManager.beginTransaction()
                            .replace(R.id.contactListFrag, fragment)
                            .addToBackStack(null)
                            .commit()
                    }
                    true -> {
                        activity!!.supportFragmentManager.beginTransaction()
                            .replace(R.id.contactInfoFrag, fragment)
                            .addToBackStack(null)
                            .commit()
                    }
                }
            }

            override fun onContactLongClick(contact: Contact) {
                val fragment = newEditInstance(contact)
                when (param_landscape) {
                    false -> {
                        activity!!.supportFragmentManager.beginTransaction()
                            .replace(R.id.contactListFrag, fragment)
                            .addToBackStack(null)
                            .commit()
                    }
                    true -> {
                        activity!!.supportFragmentManager.beginTransaction()
                            .replace(R.id.contactInfoFrag, fragment)
                            .addToBackStack(null)
                            .commit()

                    }
                }
            }
        }
    }

    fun rvInit() {
        binding.apply {
            rvContactList.layoutManager = LinearLayoutManager(context)
            rvContactList.adapter = adapter
            adapter.setContactList(ContactsData.getDataList())
        }
    }

    companion object {
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(contact: Contact) =
            ContactInfoFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, contact.name)
                    putString(ARG_PARAM2, contact.lastName)
                    putString(ARG_PARAM3, contact.phoneNumber)
                    putString(ARG_PARAM4, contact.imageUrl)
                }
            }

        fun newEditInstance(contact: Contact) =
            ContactEditFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, contact.name)
                    putString(ARG_PARAM2, contact.lastName)
                    putString(ARG_PARAM3, contact.phoneNumber)
                    putString(ARG_PARAM4, contact.imageUrl)
                    putInt(ARG_PARAM5, contact.id)
                }
            }
    }
}