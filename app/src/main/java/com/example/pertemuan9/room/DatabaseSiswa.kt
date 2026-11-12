package com.example.pertemuan9.room

import androidx.room.Database

@Database(entities = [Siswa::class], version = 1, exportSchema = false)
abstract class DatabaseSiswa {
    abstract fun siswaDao() : SiswaDao

    companion object {
        @Volatile
        private var Instance: DatabaseSiswa? = null

        fun getDatabase(context: Context): DatabaseSiswa {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    DatabaseSiswa::class.java,
                    "siswa_database"
                )
                    .build()
                    .also { Instance = it }
            }
        }
    }
}