package com.cathaybk.dbs.beanknowledge

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cathaybk.dbs.beanknowledge.databinding.PairWaitingFragmentBinding
import com.cathaybk.dbs.beanknowledge.model.WaitingNumImageIdModel
import java.util.*

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
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {

            Timer().schedule(object : TimerTask() {
                override fun run() {
                    setEvent()//需要执行的任务
                }
            }, 0, 10000)
        }
    }

    private fun PairWaitingFragmentBinding.setEvent() {
        inWaiting.tvCancelTrading.setOnClickListener {
            presenter.showClickChange()
        }

        presenter.updateWaitingNum()
    }

    override fun showNum(data: WaitingNumImageIdModel) {
        binding.inWaiting.apply {
            ivWaitingNumLeft.setImageResource(data.leftImageId)
            ivWaitingNumRight.setImageResource(data.rightImageId)
        }
    }


}
