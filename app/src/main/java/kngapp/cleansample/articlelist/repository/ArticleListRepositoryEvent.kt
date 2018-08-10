package kngapp.cleansample.articlelist.repository

import kngapp.cleansample.articlelist.domain.model.Articles

/**
 * Created by masashi on 2018/08/10.
 *
 * 記事一覧取得イベント
 */

data class ArticleListRepositoryEvent(
        val isSuccess: Boolean,
        val articleList: Articles?
)