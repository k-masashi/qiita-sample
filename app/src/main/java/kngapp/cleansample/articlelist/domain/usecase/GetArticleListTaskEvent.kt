package kngapp.cleansample.articlelist.domain.usecase

import kngapp.cleansample.articlelist.domain.model.Articles

/**
 * Created by masashi on 2018/08/10.
 *
 * 記事一覧取得イベント
 */

data class GetArticleListTaskEvent(
        val isSuccess: Boolean,
        val articleList: Articles?
)