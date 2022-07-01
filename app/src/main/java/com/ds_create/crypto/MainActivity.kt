package com.ds_create.crypto

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ds_create.crypto.models.CoinViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: CoinViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this)[CoinViewModel::class.java]
        viewModel.priceList.observe(this, Observer {
            Log.d("MyLog", "Success in activity: $it")
        })
        viewModel.getDetailInfo("BTC").observe(this, Observer {
            Log.d("MyLog", "Success in activity: $it")
        })
    }
}