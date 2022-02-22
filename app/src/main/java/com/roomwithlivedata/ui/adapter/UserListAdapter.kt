package com.roomwithlivedata.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.roomwithlivedata.database.User
import com.roomwithlivedata.databinding.ItemListBinding

class UserListAdapter(
    val list: ArrayList<User>,
   // private val listener: ClickItemListener
) :
    RecyclerView.Adapter<UserListAdapter.ViewHolder>() {

    interface ClickItemListener {
        fun onClicked(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = list[position]
        holder.bind.tvHeading.text = "Id: " + "" + model.id
        holder.bind.tvCity.text = "name: " + "" + model.name
        holder.bind.tvAge.text = "email: " + "" + model.email




//        holder.itemView.setOnClickListener {
//            listener.onClicked(position)
//        }


    }


    inner class ViewHolder(private var binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val bind = binding
    }
}