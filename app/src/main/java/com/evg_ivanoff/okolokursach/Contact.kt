package com.evg_ivanoff.okolokursach

import com.evg_ivanoff.okolokursach.databinding.FragmentContactEditBinding
import kotlin.random.Random


data class Contact(
    var id: Int,
    var name: String,
    var lastName: String,
    var phoneNumber: String,
    var imageUrl: String
)

object ContactsData {

    private val nameList = listOf<String>("Genry", "Charlie", "Tomas", "Frank", "Billy", "Monty")
    private val lastNameList = listOf<String>("Sanches", "Smith", "Jonson", "Grint", "Python")
    private val dataList = fillContactList()

    fun getDataList() = dataList

    fun editContact(id: Int, binding: FragmentContactEditBinding) {
        dataList[id].apply {
            name = binding.etName.text.toString()
            lastName = binding.etLastName.text.toString()
            phoneNumber = binding.etPhoneNumber.text.toString()
        }
    }

    fun fillContactList() : List<Contact> {
        val res = mutableListOf<Contact>()
        for (i in 0..99) {
            res.add(Contact(
                i,
                "${ContactsData.nameList.get(Random.nextInt(0, nameList.size))}",
                "${ContactsData.lastNameList.get(Random.nextInt(0, lastNameList.size))}",
                "+7${(10000..99999).random().toString()}",
                setPicture(i)
            ))
        }
        return res
    }

    fun getOneUser() : Contact {
        return Contact(
            (0..10).random(),
            "${ContactsData.nameList.get((0..nameList.size).random())}",
            "${ContactsData.lastNameList.get((0..lastNameList.size).random())}",
            "+7${(10000..99999).random().toString()}",
            setPicture(1)
        )
    }

    fun setPicture(i: Int): String {
        return "https://picsum.photos/id/$i/400"
    }

}
