package com.example.applicationlanguage.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Database(entities = [usuari::class,usuaridades::class,palabras::class,palabra_alfabeto::class,palabra_numero::class,idioma::class,palabra_frase::class], version=1, exportSchema=false)
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
                val frase = palabra_frase()
            //temas
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
                idioma.conocimiento="sentimiento"
                idioma.tema="vocabulario"
                db.databaseDao.insertidioma(idioma)
                idioma.idiomaid="4"
                idioma.idioma="ingles"
                idioma.conocimiento="personas"
                idioma.tema="frases"
                db.databaseDao.insertidioma(idioma)

            //frases
                frase.idiomaid="4"
                frase.aprenderfrase="I and you"
                frase.localfrase="yo y tú"
                db.databaseDao.insert_frases(frase)
                frase.idiomaid="4"
                frase.aprenderfrase="he and she"
                frase.localfrase="el y ella"
                db.databaseDao.insert_frases(frase)
                frase.idiomaid="4"
                frase.aprenderfrase="my family is here"
                frase.localfrase="mi familia esta aqui"
                db.databaseDao.insert_frases(frase)
                frase.idiomaid="4"
                frase.aprenderfrase="you are here"
                frase.localfrase="vosotraos estais aqui"
                db.databaseDao.insert_frases(frase)
                frase.idiomaid="4"
                frase.aprenderfrase="the man"
                frase.localfrase="el hombre"
                db.databaseDao.insert_frases(frase)
                frase.idiomaid="4"
                frase.aprenderfrase="the woman"
                frase.localfrase="la mujer"
                db.databaseDao.insert_frases(frase)
                frase.idiomaid="4"
                frase.aprenderfrase="the child"
                frase.localfrase="el niño"
                db.databaseDao.insert_frases(frase)
                frase.idiomaid="4"
                frase.aprenderfrase="a family"
                frase.localfrase="una familia"
                db.databaseDao.insert_frases(frase)
                frase.idiomaid="4"
                frase.aprenderfrase="my family"
                frase.localfrase="mi familia"
                db.databaseDao.insert_frases(frase)
            //palabras
                palabra.idiomaid="3"
                palabra.aprenderpalabra="affection"
                palabra.localpalabra="afecto"
                palabra.idiomaid="3"
                palabra.aprenderpalabra="anger"
                palabra.localpalabra="ira"
                db.databaseDao.insertpalabra(palabra)
                palabra.idiomaid="3"
                palabra.aprenderpalabra="boredom"
                palabra.localpalabra="aburrimiento"
                db.databaseDao.insertpalabra(palabra)
                palabra.idiomaid="3"
                palabra.aprenderpalabra="confidence"
                palabra.localpalabra="confianza"
                db.databaseDao.insertpalabra(palabra)
                palabra.idiomaid="3"
                palabra.aprenderpalabra="creativity"
                palabra.localpalabra="creatividad"
                db.databaseDao.insertpalabra(palabra)
                palabra.idiomaid="3"
                palabra.aprenderpalabra="curiosity"
                palabra.localpalabra="curiosidad"
                db.databaseDao.insertpalabra(palabra)
            //numero
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
            //alfabeto
                alf.idiomaid="2"
                alf.aprenderpalabra="a"
                alf.localpalabra="a"
                alf.pronunciacio_aprender="ei"
                alf.pronunciacio_local="a"
                db.databaseDao.insert_alfabeto(alf)
                alf.idiomaid="2"
                alf.aprenderpalabra="b"
                alf.localpalabra="b"
                alf.pronunciacio_aprender="bee / bi"
                alf.pronunciacio_local="b"
                db.databaseDao.insert_alfabeto(alf)
                alf.idiomaid="2"
                alf.aprenderpalabra="c"
                alf.localpalabra="c"
                alf.pronunciacio_aprender="cee / si"
                alf.pronunciacio_local="c"
                db.databaseDao.insert_alfabeto(alf)
                alf.idiomaid="2"
                alf.aprenderpalabra="d"
                alf.localpalabra="d"
                alf.pronunciacio_aprender="dee / di"
                alf.pronunciacio_local="d"
                db.databaseDao.insert_alfabeto(alf)
                alf.idiomaid="2"
                alf.aprenderpalabra="e"
                alf.localpalabra="e"
                alf.pronunciacio_aprender="i"
                alf.pronunciacio_local="e"
                db.databaseDao.insert_alfabeto(alf)
                alf.idiomaid="2"
                alf.aprenderpalabra="f"
                alf.localpalabra="f"
                alf.pronunciacio_aprender="ef"
                alf.pronunciacio_local="f"
                db.databaseDao.insert_alfabeto(alf)
                alf.idiomaid="2"
                alf.aprenderpalabra="g"
                alf.localpalabra="g"
                alf.pronunciacio_aprender="gee / di"
                alf.pronunciacio_local="g"
                db.databaseDao.insert_alfabeto(alf)
                alf.idiomaid="2"
                alf.aprenderpalabra="h"
                alf.localpalabra="h"
                alf.pronunciacio_aprender="aitch / eitj / haitch / heitj"
                alf.pronunciacio_local="h"
                db.databaseDao.insert_alfabeto(alf)
                alf.idiomaid="2"
                alf.aprenderpalabra="i"
                alf.localpalabra="i"
                alf.pronunciacio_aprender="ai"
                alf.pronunciacio_local="i"
                db.databaseDao.insert_alfabeto(alf)
                alf.idiomaid="2"
                alf.aprenderpalabra="j"
                alf.localpalabra="j"
                alf.pronunciacio_aprender="jay / jy"
                alf.pronunciacio_local="j"
                db.databaseDao.insert_alfabeto(alf)
                alf.idiomaid="2"
                alf.aprenderpalabra="k"
                alf.localpalabra="k"
                alf.pronunciacio_aprender="kay / kei"
                alf.pronunciacio_local="k"
                db.databaseDao.insert_alfabeto(alf)
                alf.idiomaid="2"
                alf.aprenderpalabra="l"
                alf.localpalabra="l"
                alf.pronunciacio_aprender="el / ell"
                alf.pronunciacio_local="l"
                db.databaseDao.insert_alfabeto(alf)
                alf.idiomaid="2"
                alf.aprenderpalabra="m"
                alf.localpalabra="m"
                alf.pronunciacio_aprender="em"
                alf.pronunciacio_local="m"
                db.databaseDao.insert_alfabeto(alf)
                alf.idiomaid="2"
                alf.aprenderpalabra="n"
                alf.localpalabra="n"
                alf.pronunciacio_aprender="en"
                alf.pronunciacio_local="n"
                db.databaseDao.insert_alfabeto(alf)
                alf.idiomaid="2"
                alf.aprenderpalabra="o"
                alf.localpalabra="o"
                alf.pronunciacio_aprender="ou"
                alf.pronunciacio_local="o"
                db.databaseDao.insert_alfabeto(alf)
                alf.idiomaid="2"
                alf.aprenderpalabra="p"
                alf.localpalabra="p"
                alf.pronunciacio_aprender="pee / pi"
                alf.pronunciacio_local="p"
                db.databaseDao.insert_alfabeto(alf)
                alf.idiomaid="2"
                alf.aprenderpalabra="q"
                alf.localpalabra="q"
                alf.pronunciacio_aprender="cue / kju"
                alf.pronunciacio_local="q"
                db.databaseDao.insert_alfabeto(alf)
                alf.idiomaid="2"
                alf.aprenderpalabra="r"
                alf.localpalabra="r"
                alf.pronunciacio_aprender="ar"
                alf.pronunciacio_local="r"
                db.databaseDao.insert_alfabeto(alf)
                alf.idiomaid="2"
                alf.aprenderpalabra="s"
                alf.localpalabra="s"
                alf.pronunciacio_aprender="ess"
                alf.pronunciacio_local="s"
                db.databaseDao.insert_alfabeto(alf)
                alf.idiomaid="2"
                alf.aprenderpalabra="t"
                alf.localpalabra="t"
                alf.pronunciacio_aprender="tee / ti"
                alf.pronunciacio_local="t"
                db.databaseDao.insert_alfabeto(alf)
                alf.idiomaid="2"
                alf.aprenderpalabra="u"
                alf.localpalabra="u"
                alf.pronunciacio_aprender="ju"
                alf.pronunciacio_local="u"
                db.databaseDao.insert_alfabeto(alf)
                alf.idiomaid="2"
                alf.aprenderpalabra="v"
                alf.localpalabra="v"
                alf.pronunciacio_aprender="vee / vi"
                alf.pronunciacio_local="v"
                db.databaseDao.insert_alfabeto(alf)
                alf.idiomaid="2"
                alf.aprenderpalabra="w"
                alf.localpalabra="w"
                alf.pronunciacio_aprender="double-u"
                alf.pronunciacio_local="w"
                db.databaseDao.insert_alfabeto(alf)
                alf.idiomaid="2"
                alf.aprenderpalabra="x"
                alf.localpalabra="x"
                alf.pronunciacio_aprender="ex / eks"
                alf.pronunciacio_local="x"
                db.databaseDao.insert_alfabeto(alf)
                alf.idiomaid="2"
                alf.aprenderpalabra="y"
                alf.localpalabra="y"
                alf.pronunciacio_aprender="wy / wye / wai"
                alf.pronunciacio_local="y"
                db.databaseDao.insert_alfabeto(alf)
                alf.idiomaid="2"
                alf.aprenderpalabra="z"
                alf.localpalabra="z"
                alf.pronunciacio_aprender="zed / zee / zi"
                alf.pronunciacio_local="z"
                db.databaseDao.insert_alfabeto(alf)
            }
        }
    }
}
