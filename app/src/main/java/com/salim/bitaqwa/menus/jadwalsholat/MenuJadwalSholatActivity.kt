package com.salim.bitaqwa.menus.jadwalsholat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
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

        initView()
    }

    private fun initView() {
        val c: Date = Calendar.getInstance().time
        val df = SimpleDateFormat("E, dd MMM", Locale.getDefault())
        val formattedDate: String = df.format(c)

        binding.tvDatePray.text = formattedDate

        initGetDataJadwalSholat()
    }

    private fun initGetDataJadwalSholat() {
        val df = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        //val formattedDate: String = df.format()

        val client = AsyncHttpClient()
        val url = "https://muslimsalat.com/bogor.json?key=6c3337e4157abee71e8bdb4b4317e273"
        client.get(url, object : AsyncHttpResponseHandler() {
            override fun onSuccess(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: ByteArray?
            ) {
                binding.pbJadwalSholat.visibility = View.INVISIBLE
                val response = responseBody?.let { String(it) }

                try {
                    val responseObject = JSONObject(response)
                    val items = responseObject.getJSONArray("items")
                    val jadwal = items.getJSONObject(0)

                    Log.d("JadwalActivity", "onSuccess: $items")

                    binding.tvPrayTimeSubuh.text = jadwal.getString("fajr")
                    binding.tvPrayTimeSunrise.text = jadwal.getString("shurooq")
                    binding.tvPrayTimeDzuhur.text = jadwal.getString("dhuhr")
                    binding.tvPrayTimeAshar.text = jadwal.getString("asr")
                    binding.tvPrayTimeMaghrib.text = jadwal.getString("maghrib")
                    binding.tvPrayTimeIsya.text = jadwal.getString("isha")
                    binding.tvLocation.text = responseObject.getString("query")
                } catch (e: Exception) {
                    Toast.makeText(this@MenuJadwalSholatActivity, e.message, Toast.LENGTH_SHORT)
                        .show()
                    e.printStackTrace()
                    Log.e("Errrrrror", "onSuccess: ${e.message}", )
                }

            }

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
            }

        })
    }
}