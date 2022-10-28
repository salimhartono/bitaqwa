package com.salim.bitaqwa.menus.doa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
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
        supportActionBar?.title = doa.title

        binding.tvTitleDoa.text = doa.title
        binding.tvTitleArab.text = doa.doa
        binding.tvTitleLatin.text = "(${doa.latin})"
        binding.tvTitleArti.text = doa.translate
        binding.tvTitleRiwayat.text = doa.profile
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