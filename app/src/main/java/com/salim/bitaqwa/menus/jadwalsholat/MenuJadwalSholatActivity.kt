package com.salim.bitaqwa.menus.jadwalsholat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.salim.bitaqwa.R
import com.salim.bitaqwa.databinding.ActivityMenuJadwalSholatBinding

class MenuJadwalSholatActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMenuJadwalSholatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuJadwalSholatBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}