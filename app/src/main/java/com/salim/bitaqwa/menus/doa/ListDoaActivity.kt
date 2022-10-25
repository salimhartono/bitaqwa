package com.salim.bitaqwa.menus.doa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.salim.bitaqwa.databinding.ActivityListDoaBinding

class ListDoaActivity : AppCompatActivity() {

    private lateinit var binding : ActivityListDoaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListDoaBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


    }
}