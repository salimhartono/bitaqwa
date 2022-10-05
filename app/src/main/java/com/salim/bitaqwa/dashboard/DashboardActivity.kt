package com.salim.bitaqwa.dashboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.salim.bitaqwa.R
import com.salim.bitaqwa.databinding.ActivityDashboardBinding
import com.salim.bitaqwa.menus.doa.MenuDoaActivity
import com.salim.bitaqwa.menus.dzikir.MenuDzikirActivity
import com.salim.bitaqwa.menus.jadwalsholat.MenuJadwalSholatActivity
import com.salim.bitaqwa.menus.videokajian.MenuVideoKajianActivity
import com.salim.bitaqwa.menus.zakat.MenuZakatActivity

class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //function menu navigasi
        initMenu()

    }

    private fun initMenu() {
        binding.ivIconMenuDoa.setOnClickListener {
            startActivity(Intent(this, MenuDoaActivity::class.java))
        }
        binding.ivIconMenuDzikir.setOnClickListener {
            startActivity(Intent(this, MenuDzikirActivity::class.java))
        }
        binding.ivIconMenuZakat.setOnClickListener {
            startActivity(Intent(this, MenuZakatActivity::class.java))
        }
        binding.ivIconMenuVideoKajian.setOnClickListener {
            startActivity(Intent(this, MenuVideoKajianActivity::class.java))
        }
        binding.ivIconMenuJadwalSholat.setOnClickListener {
            startActivity(Intent(this, MenuJadwalSholatActivity::class.java))
        }
    }
}