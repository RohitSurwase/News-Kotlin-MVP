/*
 * Copyright (C) 2017 Rohit Sahebrao Surwase.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.rohitss.news.homeMVP

/**
 * Created by RohitSS on 27-12-2017.
 */
class NewsHomePresenterImpl(private var newsHomeView: NewsHomeView?, private val newsHomeInteracter: NewsHomeInteracterImpl)
    : NewsHomePresenter, NewsHomeInteracter.OnFinishedListener {

    override fun getNewsData() {
        newsHomeView.let {
            newsHomeView?.showProgress()
            newsHomeInteracter.requestNewsDataAPI(this)
        }
    }

    override fun onDestroy() {
        newsHomeView = null
    }

    override fun onResultSuccess(arrNewsUpdates: List<ArticlesItem>) {
        newsHomeView.let {
            newsHomeView?.hideProgress()
            newsHomeView?.setNewsData(arrNewsUpdates)
        }
    }

    override fun onResultFail() {
        newsHomeView.let {
            newsHomeView?.hideProgress()
            newsHomeView?.getDataFailed()
        }
    }
}