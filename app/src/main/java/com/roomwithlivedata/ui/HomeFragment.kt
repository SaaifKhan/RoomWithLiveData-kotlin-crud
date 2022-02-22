package com.roomwithlivedata.ui
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.roomwithlivedata.MainActivity
import com.roomwithlivedata.R
import com.roomwithlivedata.databinding.FragmentHomeBinding


class HomeFragment : Fragment(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val homeBinding: FragmentHomeBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        homeBinding.bnAddUser.setOnClickListener(this)
        homeBinding.bnViewUser.setOnClickListener(this)
        homeBinding.bnDeleteUser.setOnClickListener(this)
        homeBinding.bnUpdateUser.setOnClickListener(this)
        return homeBinding.root
    }

    override fun onClick(v: View?) {
        when (v!!.id) {

            R.id.bn_add_user -> {
                (activity as MainActivity).fragmentManager?.beginTransaction()
                    ?.replace(R.id.fragment_container, AddFragment())?.addToBackStack(null)
                    ?.commit()

            }
            R.id.bn_view_user -> {
                (activity as MainActivity).fragmentManager?.beginTransaction()
                    ?.replace(R.id.fragment_container, ViewFragment())?.addToBackStack(null)
                    ?.commit()
            }

        }
    }


}