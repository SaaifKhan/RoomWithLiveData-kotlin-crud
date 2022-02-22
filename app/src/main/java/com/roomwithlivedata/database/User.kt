package com.roomwithlivedata.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "users")

data class User(
    @PrimaryKey
    var id: Int?,
    @ColumnInfo(name = "user_name")
    var name: String?,
    @ColumnInfo(name = "user_email")
    var email: String
)