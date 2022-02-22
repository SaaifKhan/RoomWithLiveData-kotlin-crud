package com.roomwithlivedata.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.roomwithlivedata.MainActivity
import com.roomwithlivedata.R
import com.roomwithlivedata.database.User
import com.roomwithlivedata.databinding.FragmentAddBinding


class AddFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val addUserFragment: FragmentAddBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_add, container, false)
        addUserFragment.btnSubmit.setOnClickListener {
            val id: Int = addUserFragment.id.text.toString().toInt()
            val name: String = addUserFragment.name.text.toString()
            val email: String = addUserFragment.email.getText().toString()

            val user = User(id, name, email)

            (activity as MainActivity).myAppDatabase!!.myDao()!!.insertEntry(user)

            Toast.makeText(context, "User added successfully", Toast.LENGTH_SHORT).show();
        }

        return addUserFragment.root;
    }



}