package com.ds_create.crypto

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ds_create.crypto.adapters.CoinInfoAdapter
import com.ds_create.crypto.databinding.ActivityCoinPriceListBinding
import com.ds_create.crypto.models.CoinViewModel
import com.ds_create.crypto.pojo.CoinPriceInfo

class CoinPriceListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCoinPriceListBinding
    private lateinit var viewModel: CoinViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoinPriceListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

     private fun init() {
        val coinAdapter = CoinInfoAdapter(this)
        coinAdapter.onCoinClickListener = object : CoinInfoAdapter.OnCoinClickListener {
            override fun onCoinClick(coinPriceInfo: CoinPriceInfo) {
                Log.d("MyLog", coinPriceInfo.fromSymbol)
            }
        }
        binding.rvCoinPriceList.adapter = coinAdapter
        viewModel = ViewModelProvider(this)[CoinViewModel::class.java]
        viewModel.priceList.observe(this, Observer {
            coinAdapter.coinInfoList = it
        })
    }
}