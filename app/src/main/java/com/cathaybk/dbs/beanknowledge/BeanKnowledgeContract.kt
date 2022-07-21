package com.cathaybk.dbs.beanknowledge

import com.cathaybk.dbs.beanknowledge.model.BeanKnowledgeModel

/**
 * Created by Ricky on 2022/7/20.
 */
interface BeanKnowledgeContract {

    interface View {
        fun showTopic(data: BeanKnowledgeModel)
    }

    interface Presenter {
        fun showBeanContent()
    }
}