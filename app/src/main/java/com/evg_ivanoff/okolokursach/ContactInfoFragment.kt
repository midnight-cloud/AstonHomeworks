package com.evg_ivanoff.okolokursach

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import coil.load
import coil.transform.CircleCropTransformation
import com.evg_ivanoff.okolokursach.databinding.FragmentContactInfoBinding

private const val ARG_PARAM1 = "name"
private const val ARG_PARAM2 = "lastName"
private const val ARG_PARAM3 = "phoneNumber"
private const val ARG_PARAM4 = "imageUrl"

class ContactInfoFragment : Fragment() {

    private lateinit var binding: FragmentContactInfoBinding
    private var param_name: String? = null
    private var param_lastName: String? = null
    private var param_phoneNumber: String? = null
    private var param_imageUrl: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param_name = it.getString(ARG_PARAM1)
            param_lastName = it.getString(ARG_PARAM2)
            param_phoneNumber = it.getString(ARG_PARAM3)
            param_imageUrl = it.getString(ARG_PARAM4)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentContactInfoBinding.inflate(inflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {
            tvName.text = param_name
            tvLastName.text = param_lastName
            tvPhoneNumber.text = param_phoneNumber
            imageContact.load(param_imageUrl) {
                crossfade(true)
                transformations(CircleCropTransformation())
            }
        }

    }

}