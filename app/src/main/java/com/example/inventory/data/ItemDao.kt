package com.example.inventory.data


import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

/*
Membuat interface ItemDao dan  menyedikan fungsi CRUD
 */


@Dao
interface ItemDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Item)

    @Update
    suspend fun update(item: Item)

    @Delete
    suspend fun delete(item: Item)

    //    Fungsi untuk mendapatkan Item berdasarakan id
    @Query("SELECT * from items WHERE id = :id")
    fun getItem(id: Int): Flow<Item>

    //    Fungsi untuk mendapatkan seluruh secara urut secara ascending(naik, a ke z/0->1)
    @Query("SELECT * from items ORDER BY name ASC")
    fun getAllItems(): Flow<List<Item>>
}