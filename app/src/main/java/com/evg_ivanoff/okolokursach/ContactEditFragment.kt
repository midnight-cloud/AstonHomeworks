package com.evg_ivanoff.okolokursach

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.load
import coil.transform.CircleCropTransformation
import com.evg_ivanoff.okolokursach.databinding.FragmentContactEditBinding

private const val ARG_PARAM1 = "name"
private const val ARG_PARAM2 = "lastName"
private const val ARG_PARAM3 = "phoneNumber"
private const val ARG_PARAM4 = "imageUrl"
private const val ARG_PARAM5 = "id"

class ContactEditFragment : Fragment() {

    private lateinit var binding: FragmentContactEditBinding
    private var param_name: String? = null
    private var param_lastName: String? = null
    private var param_phoneNumber: String? = null
    private var param_imageUrl: String? = null
    private var param_id: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param_name = it.getString(ARG_PARAM1)
            param_lastName = it.getString(ARG_PARAM2)
            param_phoneNumber = it.getString(ARG_PARAM3)
            param_imageUrl = it.getString(ARG_PARAM4)
            param_id = it.getInt(ARG_PARAM5)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentContactEditBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("MAIN_TAG", param_name.toString())
        binding.apply {
            etName.setText(param_name)
            etLastName.setText(param_lastName)
            etPhoneNumber.setText(param_phoneNumber)
            imageContact.load(param_imageUrl) {
                crossfade(true)
                transformations(CircleCropTransformation())
            }
            btnSave.setOnClickListener {
                ContactsData.editContact(param_id!!, binding)
                requireActivity().supportFragmentManager.popBackStack()
            }
        }

    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ContactEditFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}