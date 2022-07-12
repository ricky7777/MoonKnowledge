package com.cathaybk.dbs.beanknowledge

import android.app.Activity
import android.os.Bundle
import com.cathaybk.dbs.beanknowledge.databinding.MainActivityBinding
import com.cathaybk.dbs.beanknowledge.databinding.UpperLeftContentBinding

/**
 * Created by Ricky on 2022/7/5.
 */
class MainActivity : Activity() {
    private lateinit var binding: MainActivityBinding
    var rightNumber = 0
    var leftNumber = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.upperLeftContent.tvWaitingNumLeft.text = (leftNumber).toString()
        binding.upperLeftContent.tvWaitingNumRight.text = (rightNumber).toString()

        binding.upperLeftContent.tvCancelTrading.setOnClickListener{ cancelTrading() }
    }


    private fun cancelTrading() {

        if(rightNumber == 9) {
            if(leftNumber == 9) return

            rightNumber = 0
            leftNumber += 1
            binding.upperLeftContent.tvWaitingNumLeft.text = (leftNumber).toString()
            binding.upperLeftContent.tvWaitingNumRight.text = (rightNumber).toString()
        }
        else{
            rightNumber += 1
            binding.upperLeftContent.tvWaitingNumRight.text = (rightNumber).toString()
        }


    }
}