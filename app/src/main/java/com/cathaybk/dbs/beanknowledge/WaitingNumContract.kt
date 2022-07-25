package com.cathaybk.dbs.beanknowledge

import com.cathaybk.dbs.beanknowledge.model.WaitingNumImageIdModel

/**
 * Created by HouYi on 2022/7/21.
 */
interface WaitingNumContract {

    interface View {
        fun showNum(data: WaitingNumImageIdModel)
    }

    interface Presenter {
        fun updateWaitingNum()
        fun showClickChange()
        fun showGitHubUsers()
    }
}