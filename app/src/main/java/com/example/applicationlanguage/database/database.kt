package com.example.applicationlanguage.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [usuari::class, usuaridades::class,palabras::class,palabra_alfabeto::class,palabra_numero::class,idioma::class], version=2, exportSchema=false)
abstract class database: RoomDatabase() {

    abstract  val databaseDao:DatabaseDao

    companion object {

        @Volatile
        private var INSTANCE: database? = null

        fun getInstance(context: Context): database {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        database::class.java,
                        "lenguage_database"
                    )
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}