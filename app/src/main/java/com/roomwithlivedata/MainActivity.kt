package com.roomwithlivedata

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.room.Room
import com.roomwithlivedata.database.MyDatabase
import com.roomwithlivedata.ui.HomeFragment

class MainActivity : AppCompatActivity() {
    var fragmentManager: FragmentManager? = null
    var myAppDatabase: MyDatabase? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragmentManager = supportFragmentManager
        myAppDatabase = Room.databaseBuilder(applicationContext, MyDatabase::class.java, "userdb")
            .allowMainThreadQueries().build()

        if(findViewById<FrameLayout>(R.id.fragment_container)!=null){
            if (savedInstanceState!=null){
                return
            }
            fragmentManager!!.beginTransaction().add(R.id.fragment_container, HomeFragment())
                .commit()

        }

    }
    }
