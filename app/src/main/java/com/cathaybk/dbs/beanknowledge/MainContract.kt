package com.cathaybk.dbs.beanknowledge

import com.cathaybk.dbs.beanknowledge.model.BeanCardModel

/**
 * Created by Ricky on 2022/7/20.
 */
interface MainContract {

    interface View {
        fun showTopic(data: BeanCardModel)
    }

    interface Presenter {
        fun showBeanContent()
    }
}