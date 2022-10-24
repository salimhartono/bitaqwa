package com.salim.bitaqwa.menus.doa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.salim.bitaqwa.R
import com.salim.bitaqwa.databinding.ActivityDetailDoaBinding
import com.salim.bitaqwa.menus.doa.model.DoaModel

class DetailDoaActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_DOA = "extra_doa"
    }

    private lateinit var binding: ActivityDetailDoaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailDoaBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val doa = intent.getParcelableExtra<DoaModel>(EXTRA_DOA) as DoaModel
        setSupportActionBar(binding.toolbarDetailDoa)
    }
}