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
                        "lenguage_database_1"
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

                //ruso
                idioma.idiomaid="11"
                idioma.idioma="ruso"
                idioma.conocimiento="numero"
                idioma.tema="numero"
                db.databaseDao.insertidioma(idioma)
                idioma.idiomaid="12"
                idioma.idioma="ruso"
                idioma.conocimiento="alfabeto"
                idioma.tema="alfabeto"
                db.databaseDao.insertidioma(idioma)
                idioma.idiomaid="13"
                idioma.idioma="ruso"
                idioma.conocimiento="sentimiento"
                idioma.tema="vocabulario"
                db.databaseDao.insertidioma(idioma)
                idioma.idiomaid="14"
                idioma.idioma="ruso"
                idioma.conocimiento="personas"
                idioma.tema="frases"
                db.databaseDao.insertidioma(idioma)
                idioma.idiomaid="15"
                idioma.idioma="ruso"
                idioma.conocimiento="familia"
                idioma.tema="vocabulario"
                db.databaseDao.insertidioma(idioma)

                //tema
                palabra.idiomaid="15"
                palabra.aprenderpalabra="mama"
                palabra.localpalabra="madre"
                db.databaseDao.insertpalabra(palabra)
                palabra.idiomaid="15"
                palabra.aprenderpalabra="rodnoy brat"
                palabra.localpalabra="hermano"
                db.databaseDao.insertpalabra(palabra)
                palabra.idiomaid="15"
                palabra.aprenderpalabra="sestra"
                palabra.localpalabra="hermana"
                db.databaseDao.insertpalabra(palabra)
                palabra.idiomaid="15"
                palabra.aprenderpalabra="papa"
                palabra.localpalabra="padre"
                db.databaseDao.insertpalabra(palabra)
                palabra.idiomaid="15"
                palabra.aprenderpalabra="dyadya"
                palabra.localpalabra="tio"
                db.databaseDao.insertpalabra(palabra)
                palabra.idiomaid="15"
                palabra.aprenderpalabra="tetya"
                palabra.localpalabra="tia"
                db.databaseDao.insertpalabra(palabra)
                //frases

                frase.idiomaid="14"
                frase.aprenderfrase="ya i ty"
                frase.localfrase="yo y tú"
                db.databaseDao.insert_frases(frase)
                frase.idiomaid="14"
                frase.aprenderfrase="yego i yeye"
                frase.localfrase="el y ella"
                db.databaseDao.insert_frases(frase)
                frase.idiomaid="14"
                frase.aprenderfrase="moya sem'ya zdes'"
                frase.localfrase="mi familia esta aqui"
                db.databaseDao.insert_frases(frase)
                frase.idiomaid="14"
                frase.aprenderfrase="Vy zdes'"
                frase.localfrase="vosotraos estais aqui"
                db.databaseDao.insert_frases(frase)
                frase.idiomaid="14"
                frase.aprenderfrase="tot chelovek"
                frase.localfrase="el hombre"
                db.databaseDao.insert_frases(frase)
                frase.idiomaid="14"
                frase.aprenderfrase="zhenshchina"
                frase.localfrase="la mujer"
                db.databaseDao.insert_frases(frase)
                frase.idiomaid="14"
                frase.aprenderfrase="mal'chik"
                frase.localfrase="el niño"
                db.databaseDao.insert_frases(frase)
                frase.idiomaid="14"
                frase.aprenderfrase="sem'ya"
                frase.localfrase="una familia"
                db.databaseDao.insert_frases(frase)
                frase.idiomaid="14"
                frase.aprenderfrase="moya sem'ya"
                frase.localfrase="mi familia"
                db.databaseDao.insert_frases(frase)
                //palabras
                palabra.idiomaid="13"
                palabra.aprenderpalabra="zatronutyy"
                palabra.localpalabra="afecto"
                palabra.idiomaid="13"
                palabra.aprenderpalabra="pereyti k"
                palabra.localpalabra="ira"
                db.databaseDao.insertpalabra(palabra)
                palabra.idiomaid="13"
                palabra.aprenderpalabra="skuka"
                palabra.localpalabra="aburrimiento"
                db.databaseDao.insertpalabra(palabra)
                palabra.idiomaid="13"
                palabra.aprenderpalabra="doveryat'"
                palabra.localpalabra="confianza"
                db.databaseDao.insertpalabra(palabra)
                palabra.idiomaid="13"
                palabra.aprenderpalabra="tvorcheskiy podkhod"
                palabra.localpalabra="creatividad"
                db.databaseDao.insertpalabra(palabra)
                palabra.idiomaid="13"
                palabra.aprenderpalabra="lyubopytstvo"
                palabra.localpalabra="curiosidad"
                db.databaseDao.insertpalabra(palabra)
                //numero
                num.idiomaid="11"
                num.aprenderpalabra="odin"
                num.localpalabra="uno"
                num.numero=1
                db.databaseDao.insert_numero(num)
                num.idiomaid="11"
                num.aprenderpalabra="dva"
                num.localpalabra="dos"
                num.numero=2
                db.databaseDao.insert_numero(num)
                num.idiomaid="11"
                num.aprenderpalabra="tri"
                num.localpalabra="tres"
                num.numero=3
                db.databaseDao.insert_numero(num)
                num.idiomaid="11"
                num.aprenderpalabra="chetyre"
                num.localpalabra="cuatro"
                num.numero=4
                db.databaseDao.insert_numero(num)
                num.idiomaid="11"
                num.aprenderpalabra="pyat'"
                num.localpalabra="cinco"
                num.numero=5
                db.databaseDao.insert_numero(num)
                num.idiomaid="11"
                num.aprenderpalabra="shest'"
                num.localpalabra="seis"
                num.numero=6
                db.databaseDao.insert_numero(num)
                num.idiomaid="11"
                num.aprenderpalabra="Sem'"
                num.localpalabra="siete"
                num.numero=7
                db.databaseDao.insert_numero(num)
                num.idiomaid="11"
                num.aprenderpalabra="vosem'"
                num.localpalabra="ocho"
                num.numero=8
                db.databaseDao.insert_numero(num)
                num.idiomaid="11"
                num.aprenderpalabra="devyat'"
                num.localpalabra="nueve"
                num.numero=9
                db.databaseDao.insert_numero(num)
                num.idiomaid="11"
                num.aprenderpalabra="desyat'"
                num.localpalabra="diez"
                num.numero=10
                db.databaseDao.insert_numero(num)
                //alfabeto
                alf.idiomaid="12"
                alf.aprenderpalabra="a"
                alf.localpalabra="a"
                alf.pronunciacio_aprender="a"
                alf.pronunciacio_local="a"
                db.databaseDao.insert_alfabeto(alf)
                alf.idiomaid="12"
                alf.aprenderpalabra="b"
                alf.localpalabra="b"
                alf.pronunciacio_aprender="v/vj"
                alf.pronunciacio_local="b"
                db.databaseDao.insert_alfabeto(alf)
                alf.idiomaid="12"
                alf.aprenderpalabra="c"
                alf.localpalabra="c"
                alf.pronunciacio_aprender="s/sj"
                alf.pronunciacio_local="c"
                db.databaseDao.insert_alfabeto(alf)
                alf.idiomaid="12"
                alf.aprenderpalabra="p"
                alf.localpalabra="p"
                alf.pronunciacio_aprender="r/rj"
                alf.pronunciacio_local="p"
                db.databaseDao.insert_alfabeto(alf)
                alf.idiomaid="12"
                alf.aprenderpalabra="e"
                alf.localpalabra="e"
                alf.pronunciacio_aprender="je"
                alf.pronunciacio_local="e"
                db.databaseDao.insert_alfabeto(alf)

                //frances
                idioma.idiomaid="6"
                idioma.idioma="frances"
                idioma.conocimiento="numero"
                idioma.tema="numero"
                db.databaseDao.insertidioma(idioma)
                idioma.idiomaid="7"
                idioma.idioma="frances"
                idioma.conocimiento="alfabeto"
                idioma.tema="alfabeto"
                db.databaseDao.insertidioma(idioma)
                idioma.idiomaid="8"
                idioma.idioma="frances"
                idioma.conocimiento="sentimiento"
                idioma.tema="vocabulario"
                db.databaseDao.insertidioma(idioma)
                idioma.idiomaid="9"
                idioma.idioma="frances"
                idioma.conocimiento="personas"
                idioma.tema="frases"
                db.databaseDao.insertidioma(idioma)
                idioma.idiomaid="10"
                idioma.idioma="frances"
                idioma.conocimiento="familia"
                idioma.tema="vocabulario"
                db.databaseDao.insertidioma(idioma)

                //tema
                palabra.idiomaid="10"
                palabra.aprenderpalabra="mère"
                palabra.localpalabra="madre"
                db.databaseDao.insertpalabra(palabra)
                palabra.idiomaid="10"
                palabra.aprenderpalabra="frère"
                palabra.localpalabra="hermano"
                db.databaseDao.insertpalabra(palabra)
                palabra.idiomaid="10"
                palabra.aprenderpalabra="sœur"
                palabra.localpalabra="hermana"
                db.databaseDao.insertpalabra(palabra)
                palabra.idiomaid="10"
                palabra.aprenderpalabra="papa"
                palabra.localpalabra="padre"
                db.databaseDao.insertpalabra(palabra)
                palabra.idiomaid="10"
                palabra.aprenderpalabra="l'oncle"
                palabra.localpalabra="tio"
                db.databaseDao.insertpalabra(palabra)
                palabra.idiomaid="10"
                palabra.aprenderpalabra="tante"
                palabra.localpalabra="tia"
                db.databaseDao.insertpalabra(palabra)
                //frases

                frase.idiomaid="9"
                frase.aprenderfrase="moi et toi"
                frase.localfrase="yo y tú"
                db.databaseDao.insert_frases(frase)
                frase.idiomaid="9"
                frase.aprenderfrase="lui et elle"
                frase.localfrase="el y ella"
                db.databaseDao.insert_frases(frase)
                frase.idiomaid="9"
                frase.aprenderfrase="ma famille est ici"
                frase.localfrase="mi familia esta aqui"
                db.databaseDao.insert_frases(frase)
                frase.idiomaid="9"
                frase.aprenderfrase="Tu es là"
                frase.localfrase="vosotraos estais aqui"
                db.databaseDao.insert_frases(frase)
                frase.idiomaid="9"
                frase.aprenderfrase="l'homme"
                frase.localfrase="el hombre"
                db.databaseDao.insert_frases(frase)
                frase.idiomaid="9"
                frase.aprenderfrase="la femme"
                frase.localfrase="la mujer"
                db.databaseDao.insert_frases(frase)
                frase.idiomaid="9"
                frase.aprenderfrase="le garçon"
                frase.localfrase="el niño"
                db.databaseDao.insert_frases(frase)
                frase.idiomaid="9"
                frase.aprenderfrase="une famille"
                frase.localfrase="una familia"
                db.databaseDao.insert_frases(frase)
                frase.idiomaid="9"
                frase.aprenderfrase="ma famille"
                frase.localfrase="mi familia"
                db.databaseDao.insert_frases(frase)
                //palabras
                palabra.idiomaid="8"
                palabra.aprenderpalabra="affecté"
                palabra.localpalabra="afecto"
                palabra.idiomaid="8"
                palabra.aprenderpalabra="aller à"
                palabra.localpalabra="ira"
                db.databaseDao.insertpalabra(palabra)
                palabra.idiomaid="8"
                palabra.aprenderpalabra="ennui"
                palabra.localpalabra="aburrimiento"
                db.databaseDao.insertpalabra(palabra)
                palabra.idiomaid="8"
                palabra.aprenderpalabra="confiance"
                palabra.localpalabra="confianza"
                db.databaseDao.insertpalabra(palabra)
                palabra.idiomaid="8"
                palabra.aprenderpalabra="la créativité"
                palabra.localpalabra="creatividad"
                db.databaseDao.insertpalabra(palabra)
                palabra.idiomaid="8"
                palabra.aprenderpalabra="curiosité"
                palabra.localpalabra="curiosidad"
                db.databaseDao.insertpalabra(palabra)
                //numero
                num.idiomaid="6"
                num.aprenderpalabra="un"
                num.localpalabra="uno"
                num.numero=1
                db.databaseDao.insert_numero(num)
                num.idiomaid="6"
                num.aprenderpalabra="deux"
                num.localpalabra="dos"
                num.numero=2
                db.databaseDao.insert_numero(num)
                num.idiomaid="6"
                num.aprenderpalabra="trois"
                num.localpalabra="tres"
                num.numero=3
                db.databaseDao.insert_numero(num)
                num.idiomaid="6"
                num.aprenderpalabra="quatre"
                num.localpalabra="cuatro"
                num.numero=4
                db.databaseDao.insert_numero(num)
                num.idiomaid="6"
                num.aprenderpalabra="cinq"
                num.localpalabra="cinco"
                num.numero=5
                db.databaseDao.insert_numero(num)
                num.idiomaid="6"
                num.aprenderpalabra="six"
                num.localpalabra="seis"
                num.numero=6
                db.databaseDao.insert_numero(num)
                num.idiomaid="6"
                num.aprenderpalabra="sept"
                num.localpalabra="siete"
                num.numero=7
                db.databaseDao.insert_numero(num)
                num.idiomaid="6"
                num.aprenderpalabra="huit"
                num.localpalabra="ocho"
                num.numero=8
                db.databaseDao.insert_numero(num)
                num.idiomaid="6"
                num.aprenderpalabra="neuf"
                num.localpalabra="nueve"
                num.numero=9
                db.databaseDao.insert_numero(num)
                num.idiomaid="6"
                num.aprenderpalabra="dix"
                num.localpalabra="diez"
                num.numero=10
                db.databaseDao.insert_numero(num)
                //alfabeto
                alf.idiomaid="7"
                alf.aprenderpalabra="a"
                alf.localpalabra="a"
                alf.pronunciacio_aprender="a"
                alf.pronunciacio_local="a"
                db.databaseDao.insert_alfabeto(alf)
                alf.idiomaid="7"
                alf.aprenderpalabra="b"
                alf.localpalabra="b"
                alf.pronunciacio_aprender="be"
                alf.pronunciacio_local="b"
                db.databaseDao.insert_alfabeto(alf)
                alf.idiomaid="7"
                alf.aprenderpalabra="c"
                alf.localpalabra="c"
                alf.pronunciacio_aprender="ce"
                alf.pronunciacio_local="c"
                db.databaseDao.insert_alfabeto(alf)
                alf.idiomaid="7"
                alf.aprenderpalabra="d"
                alf.localpalabra="d"
                alf.pronunciacio_aprender="de"
                alf.pronunciacio_local="d"
                db.databaseDao.insert_alfabeto(alf)
                alf.idiomaid="7"
                alf.aprenderpalabra="e"
                alf.localpalabra="e"
                alf.pronunciacio_aprender="e"
                alf.pronunciacio_local="e"
                db.databaseDao.insert_alfabeto(alf)


                //ingles
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
                idioma.idiomaid="5"
                idioma.idioma="ingles"
                idioma.conocimiento="familia"
                idioma.tema="vocabulario"
                db.databaseDao.insertidioma(idioma)

                palabra.idiomaid="5"
                palabra.aprenderpalabra="mom"
                palabra.localpalabra="madre"
                db.databaseDao.insertpalabra(palabra)
                palabra.idiomaid="5"
                palabra.aprenderpalabra="brother"
                palabra.localpalabra="hermano"
                db.databaseDao.insertpalabra(palabra)
                palabra.idiomaid="5"
                palabra.aprenderpalabra="sister"
                palabra.localpalabra="hermana"
                db.databaseDao.insertpalabra(palabra)
                palabra.idiomaid="5"
                palabra.aprenderpalabra="dad"
                palabra.localpalabra="padre"
                db.databaseDao.insertpalabra(palabra)
                palabra.idiomaid="5"
                palabra.aprenderpalabra="uncle"
                palabra.localpalabra="tio"
                db.databaseDao.insertpalabra(palabra)
                palabra.idiomaid="5"
                palabra.aprenderpalabra="aunt"
                palabra.localpalabra="tia"
                db.databaseDao.insertpalabra(palabra)
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
