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
    private var rightNumber = 0
    private var leftNumber = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
            .apply {
                setContentView(root)
                upperLeftContent.tvCancelTrading.setOnClickListener { cancelTrading() }
            }
        updateVariable()
    }


    private fun cancelTrading() {

        if (rightNumber == 9 && leftNumber == 9) {
            return
        }

        if (rightNumber == 9) {
            calculCarryNum()
        } else {
            calculNum()
        }

        updateVariable()

    }

    private fun updateVariable() {
        binding.upperLeftContent.apply {
            tvWaitingNumLeft.text = (leftNumber).toString()
            tvWaitingNumRight.text = (rightNumber).toString()

        }
    }

    private fun calculCarryNum() {
        rightNumber = 0
        leftNumber += 1
    }

    private fun calculNum() {
        rightNumber += 1
    }
}
