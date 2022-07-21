package com.cathaybk.dbs.beanknowledge

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cathaybk.dbs.beanknowledge.databinding.PairWaitingFragmentBinding
import com.cathaybk.dbs.beanknowledge.model.WaitingNumModel

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
        presenter.showNumContent()
        binding.inWaiting.tvCancelTrading.setOnClickListener { presenter.showClickChange() }
        return binding.root
    }

    override fun showNum(data: WaitingNumModel) {
        binding.inWaiting.apply {
            when (data.leftNum) {
                0 -> ivWaitingNumLeft.setImageResource(R.drawable.num0)
                1 -> ivWaitingNumLeft.setImageResource(R.drawable.num1)
                2 -> ivWaitingNumLeft.setImageResource(R.drawable.num2)
                3 -> ivWaitingNumLeft.setImageResource(R.drawable.num3)
                4 -> ivWaitingNumLeft.setImageResource(R.drawable.num4)
                5 -> ivWaitingNumLeft.setImageResource(R.drawable.num5)
                6 -> ivWaitingNumLeft.setImageResource(R.drawable.num6)
                7 -> ivWaitingNumLeft.setImageResource(R.drawable.num7)
                8 -> ivWaitingNumLeft.setImageResource(R.drawable.num8)
                9 -> ivWaitingNumLeft.setImageResource(R.drawable.num9)
            }
            when (data.rightNum) {
                0 -> ivWaitingNumRight.setImageResource(R.drawable.num0)
                1 -> ivWaitingNumRight.setImageResource(R.drawable.num1)
                2 -> ivWaitingNumRight.setImageResource(R.drawable.num2)
                3 -> ivWaitingNumRight.setImageResource(R.drawable.num3)
                4 -> ivWaitingNumRight.setImageResource(R.drawable.num4)
                5 -> ivWaitingNumRight.setImageResource(R.drawable.num5)
                6 -> ivWaitingNumRight.setImageResource(R.drawable.num6)
                7 -> ivWaitingNumRight.setImageResource(R.drawable.num7)
                8 -> ivWaitingNumRight.setImageResource(R.drawable.num8)
                9 -> ivWaitingNumRight.setImageResource(R.drawable.num9)
            }

        }
    }
}
