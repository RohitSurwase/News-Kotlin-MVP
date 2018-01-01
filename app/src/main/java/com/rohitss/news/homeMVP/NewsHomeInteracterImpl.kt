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

import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import com.rohitss.news.BuildConfig
import com.rohitss.news.homeMVP.dataModel.NewsResponse

/**
 * Created by RohitSS on 27-12-2017.
 */
class NewsHomeInteracterImpl : NewsHomeInteracter {

    override fun requestNewsDataAPI(onFinishedListener: NewsHomeInteracter.OnFinishedListener) {
        AndroidNetworking.get("https://newsapi.org/v2/top-headlines?sources=bbc-news")
                .addHeaders("X-Api-Key", BuildConfig.MY_NEWS_API_KEY)
                .setTag(this)
                .setPriority(Priority.LOW)
                .build()
                .getAsObject(NewsResponse::class.java, object : ParsedRequestListener<NewsResponse> {
                    override fun onResponse(newsResponse: NewsResponse) {
                        // do anything with response
                        onFinishedListener.onResultSuccess(newsResponse.articles)
                    }

                    override fun onError(anError: ANError) {
                        // handle error
                        onFinishedListener.onResultFail()
                    }
                })
    }
}