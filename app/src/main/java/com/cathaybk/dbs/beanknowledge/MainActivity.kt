package com.cathaybk.dbs.beanknowledge

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.cathaybk.dbs.beanknowledge.databinding.MainActivityBinding
import com.cathaybk.dbs.beanknowledge.databinding.PairActivityBinding
import com.cathaybk.dbs.beanknowledge.databinding.UpperLeftContentBinding

/**
 * Created by Ricky on 2022/7/5.
 */
class MainActivity : FragmentActivity() {
    private lateinit var binding: PairActivityBinding
    private var rightNumber = 0
    private var leftNumber = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = PairActivityBinding.inflate(layoutInflater)
            .apply {
                setContentView(root)
            }
        updateVariable()

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fl_bean_knowledge, BeanKnowledgeFragment())
        transaction.commit()
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
    }

    private fun calculCarryNum() {
        rightNumber = 0
        leftNumber += 1
    }

    private fun calculNum() {
        rightNumber += 1
    }
}
