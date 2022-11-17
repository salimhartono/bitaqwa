package com.salim.bitaqwa.menus.zakat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.salim.bitaqwa.R
import com.salim.bitaqwa.databinding.ActivityMenuZakatBinding
import java.text.NumberFormat
import java.util.*

class MenuZakatActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMenuZakatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuZakatBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setSupportActionBar(binding.toolbarMenuZakat)

        //panggil fungsi initview
        initView()
    }

    //fungsi unutk menjalankan kalkulator zakat
    private fun initView() {
        binding.btnZakat.setOnClickListener {
            //buat variable nutk menampung mata uang indonesia
            val formatAmount = NumberFormat.getNumberInstance(Locale("id", "ID"))
                .format(binding.etAmountZakat.getNumericValue())
            binding.tvHartaAmount.text = "Rp. $formatAmount"

            //cek kondisi apakah hartanya sudah memenuhi nisab
            if (binding.etAmountZakat.getNumericValue()?.toInt()!! >= 85000000){
                val zakat = binding.etAmountZakat.getNumericValue()!!.toInt() * (2.5/100)
                val formatZakat = NumberFormat.getNumberInstance(Locale("id", "ID"))
                    .format(zakat)
                binding.tvAmountZakat.text = "Rp. $formatZakat"
            }else{
                Toast.makeText(
                    this,
                    "Total Harta Masih Belum Mencapai Nisab(85gr Emas",
                    Toast.LENGTH_SHORT).show()
                binding.tvAmountZakat.text = "Rp. 0"
            }
        }
    }

    //function for set menu
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_zakat, menu)
        return super.onCreateOptionsMenu(menu)
    }


    //kasih action back
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> {
                finish()
            }

            R.id.pengertian_zakat -> Toast.makeText(this, "ini adalah toas pengertian zakat", Toast.LENGTH_SHORT).show()
            R.id.info -> Toast.makeText(this, "ini adalah toas info", Toast.LENGTH_SHORT).show()

        }
        return super.onOptionsItemSelected(item)
    }
}