package com.example.pertemuan9.room

import androidx.room.Insert
import androidx.room.Query

interface SiswaDao {
    @Insert(onConflict = onConflictStrategy.IGNORE)
    suspend fun insert(siswa: Siswa)

    @Query("SELECT * FROM tblSiswa ORDER BY nama ASC")
    fun getAllSiswa(): Flow<List<Siswa>>
}