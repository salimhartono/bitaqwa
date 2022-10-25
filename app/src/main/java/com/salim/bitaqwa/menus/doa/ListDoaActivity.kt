package com.salim.bitaqwa.menus.doa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.salim.bitaqwa.databinding.ActivityListDoaBinding

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


    }
}