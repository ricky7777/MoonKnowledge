package com.cathaybk.dbs.beanknowledge

import android.app.Activity
import android.os.Bundle
import com.cathaybk.dbs.beanknowledge.adapter.AnimationListAdapter
import com.cathaybk.dbs.beanknowledge.databinding.FordActivityBinding
import com.cathaybk.dbs.beanknowledge.widget.FolioView


/**
 * Created by Ricky on 2022/7/19.<br/>
 * this is card ford animation sample
 */
class FordActivity : Activity() {
    private lateinit var binding: FordActivityBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FordActivityBinding.inflate(layoutInflater)
            .apply {
                setContentView(root)
            }
        initView()
    }

    private fun initView() {
        binding.folioListviewActList.apply {
            setAdapter(AnimationListAdapter(context))
            setAnimationClass(FolioView::class.java)
            setIsVertical(true)
        }
    }


}
