package com.salim.bitaqwa.menus.doa

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
    }
}