package com.salim.bitaqwa.dashboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.salim.bitaqwa.R
import com.salim.bitaqwa.dashboard.adapter.InpirationListAdapter
import com.salim.bitaqwa.dashboard.data.InspirationData
import com.salim.bitaqwa.dashboard.model.InspirationModel
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

        //function menampilkan list inspirations
        initRecylerViewInpiration()

    }

    private fun initRecylerViewInpiration() {
        val list : ArrayList<InspirationModel> = arrayListOf()
        binding.rvInpirations.setHasFixedSize(true)
        list.addAll(InspirationData.listData)
        binding.rvInpirations.layoutManager = LinearLayoutManager(this)
        val listAdapter = InpirationListAdapter(list)
        binding.rvInpirations.adapter = listAdapter
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