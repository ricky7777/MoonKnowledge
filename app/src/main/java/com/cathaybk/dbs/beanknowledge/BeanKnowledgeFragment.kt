package com.cathaybk.dbs.beanknowledge

import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.customview.widget.ViewDragHelper
import androidx.fragment.app.Fragment
import com.cathaybk.dbs.beanknowledge.databinding.PairBeanKnowledgeFragmentBinding
import com.cathaybk.dbs.beanknowledge.model.BeanCardModel

class BeanKnowledgeFragment : Fragment(), MainContract.View {
    private var presenter: MainContract.Presenter = MainPresenter(this)

    companion object {
        private const val DROP_CARD_X_VECTOR = 6000
        private const val DROP_CARD_X = 150
        private const val ADD_CARD_INDEX = 0
        private const val CARD_ALPHA_90 = 0.9f
        private const val CARD_ALPHA_100 = 1f
        private val CARD_DEGREE = floatArrayOf(0f, -1f, 1f)
    }

    private var viewReadyToRemoved: View? = null
    private var cardNumber = 0
    private lateinit var binding: PairBeanKnowledgeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = PairBeanKnowledgeFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addCard(4)
        binding.run {
            rlParent.setViewDragListener(object : DraggableRelativeLayout.ViewDragListener {

                override fun onViewCaptured(view: View, i: Int) {
                }

                override fun onViewReleased(view: View, vx: Float, vy: Float) {
//                    LogUtils.d("${view.x} ${view.y} $vx ${view.translationY}")
                    if (view.x - getOriginalCenterX(
                            view,
                            rlParent
                        ) >= dpToPx(DROP_CARD_X) || vx > DROP_CARD_X_VECTOR
                    ) {
                        rlParent.smoothSlideViewTo(
                            view,
                            rlParent.width + view.width / 2,
                            rlParent.height / 2
                        )
                        viewReadyToRemoved = view
                    } else {
                        rlParent.moveViewToCenter(view)
                    }
                    rlParent.postInvalidate()
                }

                override fun onViewPositionChanged(
                    changedView: View,
                    x: Int,
                    y: Int,
                    dx: Int,
                    dy: Int
                ) {
                    changedView.rotation += dx.toFloat() / 50f
                    if (x - getOriginalCenterX(changedView, rlParent) >= dpToPx(DROP_CARD_X)) {
                        changedView.alpha = CARD_ALPHA_90
                    } else {
                        changedView.alpha = CARD_ALPHA_100
                    }
                }

                override fun onViewDragStateChanged(state: Int) {
                    if (state == ViewDragHelper.STATE_IDLE) {
                        if (removeCard()) {
                            addCard()
                        }
                    }
                }
            })
        }
    }

    private fun getOriginalCenterX(view: View, parent: View): Int {
        return parent.width / 2 - view.width / 2
    }

    private fun getOriginalCenterY(view: View, parent: View): Int {
        return parent.height / 2 - view.height / 2
    }

    private fun DraggableRelativeLayout.moveViewToCenter(view: View) {
        smoothSlideViewTo(view, getOriginalCenterX(view, this), getOriginalCenterY(view, this))
    }

    private fun removeCard(): Boolean {
        return viewReadyToRemoved?.let {
            binding.rlParent.removeView(it)
            viewReadyToRemoved = null
            true
        } ?: false
    }

    private fun addCard(times: Int) {
        for (i in 0..times) {
            addCard()
        }
    }

    private fun addCard() {
        cardNumber = (cardNumber + 1).mod(3)
        val materialCardView = layoutInflater.inflate(R.layout.item_bean_knowledge_card, null)
        //TODO 修改卡片內容
        materialCardView.layoutParams = binding.inSlideCardTemplate.root.layoutParams
        materialCardView.rotation = CARD_DEGREE[cardNumber.mod(3)]

        binding.rlParent.addView(materialCardView, ADD_CARD_INDEX) //放在最下面
    }

    private fun dpToPx(dp: Int): Int {
        return (dp * Resources.getSystem().displayMetrics.density + 0.5).toInt()
    }

    override fun showTopic(data: BeanCardModel) {
//        binding.tvReceivedHint.text = data.title
    }
}