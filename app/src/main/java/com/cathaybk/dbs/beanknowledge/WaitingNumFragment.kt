package com.cathaybk.dbs.beanknowledge

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cathaybk.dbs.beanknowledge.databinding.PairWaitingFragmentBinding
import com.cathaybk.dbs.beanknowledge.model.WaitingNumImageIdModel

/**
 * Created by HouYi on 2022/7/21.
 */
class WaitingNumFragment : Fragment(), WaitingNumContract.View {
    private lateinit var binding: PairWaitingFragmentBinding
    private var presenter: WaitingNumContract.Presenter = WaitingNumPresenter(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = PairWaitingFragmentBinding.inflate(inflater)
        binding.inWaiting.tvCancelTrading.setOnClickListener { presenter.showClickChange() }
        return binding.root
    }

    override fun showNum(data: WaitingNumImageIdModel) {
        binding.inWaiting.ivWaitingNumLeft.setImageResource(data.leftImageId)
        binding.inWaiting.ivWaitingNumRight.setImageResource(data.rightImageId)
    }
}