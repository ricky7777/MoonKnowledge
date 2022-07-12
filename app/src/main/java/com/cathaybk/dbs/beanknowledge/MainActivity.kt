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

        updateVariable()

        binding.upperLeftContent.tvCancelTrading.setOnClickListener { cancelTrading() }
    }


    private fun cancelTrading() {

        if (rightNumber == 9 && leftNumber == 9) {
            return
        }

        if (rightNumber == 9) {
            calculCarryNum()
            updateVariable()
        } else {
            calculNum()
            updateVariable()
        }


    }

    private fun updateVariable() {
        binding.upperLeftContent.tvWaitingNumLeft.text = (leftNumber).toString()
        binding.upperLeftContent.tvWaitingNumRight.text = (rightNumber).toString()
    }

    private fun calculCarryNum() {
        rightNumber = 0
        leftNumber += 1
    }

    private fun calculNum() {
        rightNumber += 1
    }
}
