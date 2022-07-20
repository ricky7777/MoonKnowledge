package com.cathaybk.dbs.beanknowledge

import com.cathaybk.dbs.beanknowledge.model.BeanCardModel

/**
 * Created by Ricky on 2022/7/20.
 */
class MainPresenter(val view: MainContract.View) : MainContract.Presenter {
    override fun showBeanContent() {
        val data = BeanCardModel(title = "測試標題顯示YA")
        view.showTopic(data)
    }
}