package com.cathaybk.dbs.beanknowledge

import com.cathaybk.dbs.beanknowledge.model.BeanKnowledgeTopicModel

/**
 * Created by Ricky on 2022/7/20.
 */
interface BeanKnowledgeContract {

    interface View {
        fun showTopic(data: BeanKnowledgeTopicModel)
    }

    interface Presenter {
        fun showBeanContent()
    }
}