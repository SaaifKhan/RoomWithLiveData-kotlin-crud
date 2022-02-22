package com.roomwithlivedata.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.roomwithlivedata.MainActivity
import com.roomwithlivedata.R
import com.roomwithlivedata.database.User
import com.roomwithlivedata.databinding.FragmentViewBinding
import com.roomwithlivedata.ui.adapter.UserListAdapter
import kotlinx.android.synthetic.main.fragment_view.*


class ViewFragment : Fragment() {
    val masterList = ArrayList<User>()
    lateinit var userListAdapter: UserListAdapter




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val viewUserFragment: FragmentViewBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_view, container, false)

        val allItems =(activity as MainActivity).myAppDatabase!!.myDao()!!.getAllItem()

        allItems.observe(viewLifecycleOwner, Observer {
            Log.d("Item ", "${it.size}")
            masterList.clear()
            masterList.addAll(it)
            userListAdapter = UserListAdapter(masterList)
            recyclerViewListOfResident.adapter = userListAdapter
            userListAdapter.notifyDataSetChanged()
        })










        return viewUserFragment.root;




    }

}