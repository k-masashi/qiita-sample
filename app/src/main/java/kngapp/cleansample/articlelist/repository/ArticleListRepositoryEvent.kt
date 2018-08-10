package kngapp.cleansample.articlelist.repository

import kngapp.cleansample.articlelist.domain.model.Articles

/**
 * Created by masashi on 2018/08/10.
 *
 * Repositoryの記事一覧取得イベント
 *
 * @param isSuccess リポジトリからの記事一覧取得に成功したかのフラグ
 * @param articleList 記事一覧
 */

data class ArticleListRepositoryEvent(
        val isSuccess: Boolean,
        val articleList: Articles?
)