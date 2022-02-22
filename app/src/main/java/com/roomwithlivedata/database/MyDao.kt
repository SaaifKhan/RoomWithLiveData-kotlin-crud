package com.roomwithlivedata.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MyDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertEntry(model:User)


    @Query("SELECT * FROM users")
    fun getAllItem(): LiveData<List<User>>


    @Update
    fun update(user: User?)

    @Delete
    fun delete(user: User?)



}