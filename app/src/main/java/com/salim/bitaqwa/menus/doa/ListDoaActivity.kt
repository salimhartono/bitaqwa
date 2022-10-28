package com.salim.bitaqwa.menus.doa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.salim.bitaqwa.R
import com.salim.bitaqwa.databinding.ActivityListDoaBinding
import com.salim.bitaqwa.menus.doa.adapter.DoaListAdapter
import com.salim.bitaqwa.menus.doa.data.*
import com.salim.bitaqwa.menus.doa.model.DoaModel

class ListDoaActivity : AppCompatActivity() {

    private lateinit var binding : ActivityListDoaBinding
    lateinit var title : String
    var logo : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListDoaBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        title = intent.getStringExtra("ext_title").toString()
        logo = intent.getIntExtra("ext_icon", 0)
        setSupportActionBar(binding.toolbarListDoa)
        supportActionBar?.title = title

        //panggil dan buat function
        initRecyclerView()

    }


    private fun initRecyclerView() {
        val list : ArrayList<DoaModel> = arrayListOf()
        //setting title sesuai menu
        when(title){
            getString(R.string.text_pagi_malam) ->
                list.addAll(DoaPagiMalamData.listDoaPagiDanMalamData)
            getString(R.string.keluar_rumah) ->
                list.addAll(DoaRumahData.listDoaRumahData)
            getString(R.string.makan_dan_minum)->
                list.addAll(DoaMakanDanMinumData.listDoaMakananDanMinumanData)
            getString(R.string.text_perjalanan)->
                list.addAll(DoaPerjalananData.listDoaPerjalananData)
            getString(R.string.text_sholat)->
                list.addAll(DoaSholatData.listDoaShalatData)
            getString(R.string.text_etika_baik)->
                list.addAll(DoaEtikaData.listDoaEtikaBaikData)
        }
        binding.rvDoa.setHasFixedSize(true)
        binding.rvDoa.layoutManager = LinearLayoutManager(this)
        val listDoa = DoaListAdapter(list, title, logo)
        binding.rvDoa.adapter = listDoa
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

}