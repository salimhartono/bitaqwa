package com.salim.bitaqwa.menus.videokajian

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.salim.bitaqwa.R
import com.salim.bitaqwa.databinding.ActivityMenuVideoKajianBinding
import com.salim.bitaqwa.menus.videokajian.adapter.VideoKajianAdapter
import com.salim.bitaqwa.menus.videokajian.data.VideoKajianData
import com.salim.bitaqwa.menus.videokajian.model.VideoKajianModel

class MenuVideoKajianActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuVideoKajianBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuVideoKajianBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //set action toolbarnya
        setSupportActionBar(binding.toolbarMenuVideoKajian)

        //call function
        initRecylerView()
    }

    //create function recycler view
    private fun initRecylerView() {
        val list: ArrayList<VideoKajianModel> = arrayListOf()
        binding.rvVideoKajian.setHasFixedSize(true)
        list.addAll(VideoKajianData.listData)
        binding.rvVideoKajian.layoutManager = LinearLayoutManager(this)
        val listViewAdapter = VideoKajianAdapter(list)
        binding.rvVideoKajian.adapter = listViewAdapter
    }

}