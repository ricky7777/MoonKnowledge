package com.cathaybk.dbs.beanknowledge

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.fragment.app.FragmentActivity
import com.cathaybk.dbs.beanknowledge.databinding.PairActivityBinding

/**
 * Created by Ricky on 2022/7/5.
 */
class MainActivity : FragmentActivity() {
    private lateinit var binding: PairActivityBinding
    private var rightNumber = 0
    private var leftNumber = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        setStatusBarTransparent()
        super.onCreate(savedInstanceState)
        binding = PairActivityBinding.inflate(layoutInflater)
            .apply {
                setContentView(root)
            }
        updateVariable()

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fl_bean_knowledge, BeanKnowledgeFragment())
        transaction.replace(R.id.fl_waiting, WaitingFragment())
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

    private fun setStatusBarTransparent() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //5.0 全透明实现
            val window = window
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR or View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.TRANSPARENT
            window.navigationBarColor = Color.rgb(242, 242, 242)
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //4.4 全透明状态栏
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        }
    }

}
