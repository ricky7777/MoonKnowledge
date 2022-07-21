package com.cathaybk.dbs.beanknowledge

import com.cathaybk.dbs.beanknowledge.model.WaitingNumModel

/**
 * Created by HouYi on 2022/7/21.
 */
interface WaitingNumContract {

    interface View {
        fun showNum(data: WaitingNumModel)
    }

    interface Presenter {
        fun showNumContent()
        fun showClickChange()
    }
}