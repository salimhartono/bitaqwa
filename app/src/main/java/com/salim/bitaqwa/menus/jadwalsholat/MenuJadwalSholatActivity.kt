package com.salim.bitaqwa.menus.jadwalsholat

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import com.salim.bitaqwa.R
import com.salim.bitaqwa.databinding.ActivityMenuJadwalSholatBinding
import cz.msebera.android.httpclient.Header
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.*

class MenuJadwalSholatActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMenuJadwalSholatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuJadwalSholatBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //buat variable unutk menampung api key
        var key = getString(R.string.API_KEY)
        var city = "cilacap"

        //get current time
        val sdf = SimpleDateFormat("EEE, dd MMM yyyy", Locale.getDefault())
        val currentDate = sdf.format(Date())
        binding.tvDatePray.text = currentDate

        //call function untuk mendaptkan data jadwal sholat
        getJadwalSholatData(city, key)


    }

    private fun getJadwalSholatData(city : String, key: String) {
        val url = "https://muslimsalat.com/$city.json?key=$key"

        val client = AsyncHttpClient()

        client.get(url, object :AsyncHttpResponseHandler(){
            // handler data ketika sukses
            override fun onSuccess(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: ByteArray?
            ) {
                //atur agar progresbar hilang ketika data berhasil ditampilkan
                binding.pbJadwalSholat.visibility = View.GONE

                val response = responseBody?.let { String(it) }

                //handle resposne datanya
                val responseObject = JSONObject(response)
                val items = responseObject.getJSONArray("items")
                val jadwal = items.getJSONObject(0)

                //masukan objek data kedalam variable text
                try {
                    binding.tvSubuh.text = jadwal.getString("fajr")
                    binding.tvPrayTimeSunrise.text = jadwal.getString("shurooq")
                    binding.tvPrayTimeDzuhur.text = jadwal.getString("dhuhr")
                    binding.tvPrayTimeAshar.text = jadwal.getString("asr")
                    binding.tvPrayTimeMaghrib.text = jadwal.getString("maghrib")
                    binding.tvPrayTimeIsya.text = jadwal.getString("isha")

                    //tambah dan masukan nama kota
                    val namaKota = responseObject.getString("title")
                    if (namaKota.equals("")){
                        binding.tvLocation.text = getString(R.string.empt_city)
                    }else{
                        binding.tvLocation.text = namaKota
                    }


                } catch (e: Exception) {
                    //apa yang dilakukan ketika gagal mendapatkan data
                    Toast.makeText(this@MenuJadwalSholatActivity, e.message, Toast.LENGTH_SHORT).show()
                    e.printStackTrace()
                }
            }

            //handler data ketika fail/gagal
            override fun onFailure(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: ByteArray?,
                error: Throwable?
            ) {
                binding.pbJadwalSholat.visibility = View.INVISIBLE
                val errorMessage = when (statusCode) {
                    401 -> "$statusCode : Bad Request"
                    403 -> "$statusCode : Forbidden"
                    404 -> "$statusCode : Not Found"
                    else -> "$statusCode : ${error?.message}"
                }
                Toast.makeText(this@MenuJadwalSholatActivity, errorMessage, Toast.LENGTH_SHORT)
                    .show()
                Log.e("Kota eror", "onFailure: $errorMessage")
            }

        })

    }
}