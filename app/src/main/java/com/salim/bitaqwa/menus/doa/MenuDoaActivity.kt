package com.salim.bitaqwa.menus.doa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.salim.bitaqwa.R
import com.salim.bitaqwa.databinding.ActivityMenuDoaBinding

class MenuDoaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuDoaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuDoaBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //memberikan aksi pada toolbar
        setSupportActionBar(binding.tbMenuDoa)

        //function menu
        initView()
    }

    private fun initView() {
        //action di menu doa pagi dan malam
        binding.cardDoaPagiMalam.setOnClickListener {
            val intent = Intent(this, ListDoaActivity::class.java)
            intent.putExtra("ext_title", getString(R.string.text_pagi_malam))
            intent.putExtra("ext_icon", R.drawable.ic_doa_pagi_malam)
            startActivity(intent)
        }

        //action menu doa rumah
        binding.cardDoaKeluarRumah.setOnClickListener {
            val intent = Intent(this, ListDoaActivity::class.java)
            intent.putExtra("ext_title", getString(R.string.keluar_rumah))
            intent.putExtra("ext_icon", R.drawable.ic_doa_rumah)
            startActivity(intent)
        }

        //action menu makan minum
        binding.cardDoaMakanMinum.setOnClickListener {
            val intent = Intent(this, ListDoaActivity::class.java)
            intent.putExtra("ext_title", getString(R.string.makan_dan_minum))
            intent.putExtra("ext_icon", R.drawable.ic_doa_makanan_minuman)
            startActivity(intent)
        }

        //action menu makan minum
        binding.cardDoaPerjalanan.setOnClickListener {
            val intent = Intent(this, ListDoaActivity::class.java)
            intent.putExtra("ext_title", getString(R.string.text_perjalanan))
            intent.putExtra("ext_icon", R.drawable.ic_doa_perjalanan)
            startActivity(intent)
        }

        //action menu makan minum
        binding.cardDoaSholat.setOnClickListener {
            val intent = Intent(this, ListDoaActivity::class.java)
            intent.putExtra("ext_title", getString(R.string.text_sholat))
            intent.putExtra("ext_icon", R.drawable.ic_doa_sholat)
            startActivity(intent)
        }

        //action menu makan minum
        binding.cardDoaEtika.setOnClickListener {
            val intent = Intent(this, ListDoaActivity::class.java)
            intent.putExtra("ext_title", getString(R.string.text_etika_baik))
            intent.putExtra("ext_icon", R.drawable.ic_doa_etika_baik)
            startActivity(intent)
        }


    }
}