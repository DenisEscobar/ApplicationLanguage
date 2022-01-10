package com.example.applicationlanguage.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Database(entities = [usuari::class, usuaridades::class,palabras::class,palabra_alfabeto::class,palabra_numero::class,idioma::class], version=3, exportSchema=false)
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
                        .addCallback(object : Callback() {
                            override fun onCreate(db: SupportSQLiteDatabase) {
                                super.onCreate(db)
                                Thread(Runnable { prepopulate(getInstance(context)) }).start()
                            }
                        })
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }

        private fun prepopulate(db: database) {
            GlobalScope.launch {
                val num = palabra_numero()
                val idioma = idioma()
                val alf = palabra_alfabeto()
                val palabra = palabras()

                idioma.idiomaid="1"
                idioma.idioma="ingles"
                idioma.conocimiento="numero"
                idioma.tema="numero"
                db.databaseDao.insertidioma(idioma)

                idioma.idiomaid="2"
                idioma.idioma="ingles"
                idioma.conocimiento="alfabeto"
                idioma.tema="alfabeto"
                db.databaseDao.insertidioma(idioma)

                idioma.idiomaid="3"
                idioma.idioma="ingles"
                idioma.conocimiento="palabra"
                idioma.tema="sentimiento"
                db.databaseDao.insertidioma(idioma)

                num.idiomaid="1"
                num.aprenderpalabra="one"
                num.localpalabra="uno"
                num.numero=1
                db.databaseDao.insert_numero(num)

                num.idiomaid="1"
                num.aprenderpalabra="two"
                num.localpalabra="dos"
                num.numero=2
                db.databaseDao.insert_numero(num)

                num.idiomaid="1"
                num.aprenderpalabra="three"
                num.localpalabra="tres"
                num.numero=3
                db.databaseDao.insert_numero(num)

                num.idiomaid="1"
                num.aprenderpalabra="four"
                num.localpalabra="cuatro"
                num.numero=4
                db.databaseDao.insert_numero(num)

                num.idiomaid="1"
                num.aprenderpalabra="five"
                num.localpalabra="cinco"
                num.numero=5
                db.databaseDao.insert_numero(num)

                num.idiomaid="1"
                num.aprenderpalabra="six"
                num.localpalabra="seis"
                num.numero=6
                db.databaseDao.insert_numero(num)

                num.idiomaid="1"
                num.aprenderpalabra="seven"
                num.localpalabra="siete"
                num.numero=7
                db.databaseDao.insert_numero(num)

                num.idiomaid="1"
                num.aprenderpalabra="eight"
                num.localpalabra="ocho"
                num.numero=8
                db.databaseDao.insert_numero(num)

                num.idiomaid="1"
                num.aprenderpalabra="nine"
                num.localpalabra="nueve"
                num.numero=9
                db.databaseDao.insert_numero(num)

                num.idiomaid="1"
                num.aprenderpalabra="ten"
                num.localpalabra="diez"
                num.numero=10
                db.databaseDao.insert_numero(num)

                alf.idiomaid="2"
                alf.aprenderpalabra="a"
                alf.localpalabra="a"
                alf.pronunciacio_aprender="a"
                alf.pronunciacio_local="a"
                db.databaseDao.insert_alfabeto(alf)
            }
        }
    }
}
