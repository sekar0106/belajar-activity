package io.github.sekar0106.materifintech

import android.content.Context
import androidx.preference.PreferenceManager
import java.nio.channels.spi.AbstractSelectionKey

//class buat preference
class PreferenceUtil private constructor(context: Context){

    //membuat companion objek untuk manggil preference utilnya
    companion object{

        private var instance: PreferenceUtil? = null

        //buat new instance, parameter sama seperti constructor,
        //kalo pake instance nnti functionnya jadi nullable,
        //jadi pake scenario operator dan diisi pake preferences utilnya,
        //logicnya : pada function instance saat dipanggil dan instance belom ada isinya,
        //nanti dia bakal bikin objek preference util, lalu sekalian kita nge set pakai objek yang udah dibuat td.
        //kalau mau dipanggil lagi, objek sudah terisi di variabelnya sehingga tidak bikin objek lagi
        fun newInstance(context: Context) = instance ?: PreferenceUtil(context).also {
            instance = it
        }
    }

    private val prefs = PreferenceManager.getDefaultSharedPreferences(context)

    //preference untuk menyimpan data yang simple2 seperti string,boolean,dll
    //menyimpan preference lalu di apply
    fun setString(key: String, value: String) = prefs.edit().putString(key, value).apply()
    fun setBoolean(key: String, value: Boolean) = prefs.edit().putBoolean(key, value).apply()

    //buat function untuk mengambil data
    fun getString(key: String) = prefs.getString(key, null)
    fun  getBoolean(key: String) = prefs.getBoolean(key, false)


}