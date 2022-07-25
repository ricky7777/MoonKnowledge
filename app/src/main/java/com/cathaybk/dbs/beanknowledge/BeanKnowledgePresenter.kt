package com.cathaybk.dbs.beanknowledge

import com.cathaybk.dbs.beanknowledge.model.BeanKnowledgeTopicModel

/**
 * Created by Ricky on 2022/7/20.
 */
class BeanKnowledgePresenter(val view: BeanKnowledgeContract.View) : BeanKnowledgeContract.Presenter {
    override fun showBeanContent() {
        val data = BeanKnowledgeTopicModel(title = "測試標題顯示YA")
        view.showTopic(data)
    }
}