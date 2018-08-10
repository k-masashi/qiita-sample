package kngapp.cleansample.articlelist

import kngapp.cleansample.articlelist.domain.model.Article
import kngapp.cleansample.articlelist.domain.usecase.GetArticleListTaskEvent
import kngapp.cleansample.base.BasePresenter
import kngapp.cleansample.base.BaseView

/**
 * Created by masashi on 2018/08/09.
 *
 * 記事一覧取得のPresenterとViewをつなぐContractクラス
 */

interface ArticleListContract {

    interface View : BaseView<Presenter> {

        /**
         * 記事一覧を出力する
         * @param articles 記事一覧のリスト
         */
        fun showArticles(articles: List<Article>)

        /**
         * 記事一覧の取得に失敗した場合のエラー表示
         */
        fun showGetArticlesError()


        /**
         * 記事詳細画面への遷移メソッド
         *
         * @param article Articleクラス
         */
        fun showArticleDetailActivity(article: Article)

    }

    interface Presenter : BasePresenter {

        /**
         * 記事一覧のロードメソッド
         */
        fun loadArticlesTask()

        /**
         * 記事一覧のロード完了メソッド
         *
         * @param event 記事一覧取得イベント
         */
        fun loadCompletedArticlesTask(event: GetArticleListTaskEvent)

        /**
         * 記事一覧から記事を選択するメソッド
         *
         * @param which 記事一覧のインデックス
         */
        fun selectArticleTask(which: Int)
    }
}

