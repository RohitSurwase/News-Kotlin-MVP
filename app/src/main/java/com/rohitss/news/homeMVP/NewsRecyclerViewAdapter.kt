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

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rohitss.news.R
import com.rohitss.news.homeMVP.dataModel.ArticlesItem
import kotlinx.android.synthetic.main.item_news_list_recycler.view.*

/**
 * Created by RohitSS on 27-12-2017.
 */
class NewsRecyclerViewAdapter(private val arrNewsUpdates: List<ArticlesItem>) : RecyclerView.Adapter<NewsRecyclerViewAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news_list_recycler, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(arrNewsUpdates[position])
    }

    override fun getItemCount(): Int {
        return arrNewsUpdates.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(articlesItem: ArticlesItem) = with(itemView) {
            textView_title.text = articlesItem.title
            textView_author.text = articlesItem.author
            textView_description.text = articlesItem.description
        }

    }
}