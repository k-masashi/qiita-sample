package kngapp.cleansample.articlelist.domain.usecase

import kngapp.cleansample.articlelist.domain.model.Articles

/**
 * Created by masashi on 2018/08/10.
 *
 * 記事一覧取得イベント
 *
 * @param isSuccess 記事一覧取得に成功したかどうかのフラグ
 * @param articleList 記事一覧
 */

data class GetArticleListTaskEvent(
        val isSuccess: Boolean,
        val articleList: Articles?
)