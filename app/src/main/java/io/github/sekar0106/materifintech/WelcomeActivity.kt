package io.github.sekar0106.materifintech

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class WelcomeActivity : AppCompatActivity() {

    //panggil button dan edit text
    lateinit var etNama: EditText
    lateinit var btnSubmit: Button

    //panggil preference yang sudah dibuat
    lateinit var prefUtil: PreferenceUtil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        prefUtil = PreferenceUtil.newInstance(this)

        etNama = findViewById(R.id.et_nama)
        btnSubmit = findViewById(R.id.btn_submit)

        etNama.setText(prefUtil.getString("nama"))
        //ketika button di klik maka akan memanggil saveData
        btnSubmit.setOnClickListener {
            saveData()
            //setelah submit untuk memunculkan diTextView bagian MainActivity
            val intentMainActivity = Intent(this, MainActivity::class.java).apply {
                //pas sudah masuk ke aktivity maka tidak bisa kembali ke welcome karena perlu menambahkan flag agar bisa kembali
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            startActivity(intentMainActivity)
        }


    }
    //bikin function untuk menyimpan datanya
    private fun saveData(){
        //trim untuk menghilangkan space di depan dan belakang
        val nama = etNama.text.toString().trim()
        //key nanti yang akan dipakai ketika getString, jadi untuk menandai apa yang mau disimpan
        prefUtil.setString("nama", nama)
        //setelah simpan data, lalu simpan namanya, lalu dibuat untuk mengecek
        // apakah sudah login atau belum
        prefUtil.setBoolean("is_login", true)
    }
}