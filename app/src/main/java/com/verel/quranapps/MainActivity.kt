package com.verel.quranapps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.verel.quranapps.network.AlquranModel
import com.verel.quranapps.network.Config
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvQuran : RecyclerView = findViewById(R.id.rv_quran)

        Config().service().listRepos().enqueue(object : Callback<AlquranModel>{
            override fun onResponse(call: Call<AlquranModel>, response: Response<AlquranModel>) {
                val respon = response.body()!!

            }

            override fun onFailure(call: Call<AlquranModel>, t: Throwable) {
                Toast.makeText(this@MainActivity, "$t", Toast.LENGTH_LONG).show()
            }

        })

    }
}