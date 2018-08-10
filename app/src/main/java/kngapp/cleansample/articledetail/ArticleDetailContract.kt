package kngapp.cleansample.articledetail

/**
 * Created by masashi on 2018/08/09.
 *
 * 記事詳細画面のPresenterとViewをつなぐContractクラス
 */

import android.content.Intent
import kngapp.cleansample.base.BasePresenter
import kngapp.cleansample.base.BaseView

interface ArticleDetailContract {

    interface View : BaseView<Presenter> {

        /**
         * 記事のタイトルを出力する
         * @param title タイトル
         */
        fun showTitle(title: String)

        /**
         * 詳細の本文を出力する
         * @param body 本文
         */
        fun showBody(body: String)

        /**
         * 詳細の本文の取得失敗エラーを表示
         */
        fun showFailedLoadBodyError()

    }

    interface Presenter : BasePresenter {

        /**
         * 記事情報取得タスク
         *
         * @param intent 詳細画面に渡されたintent
         */
        fun loadArticleInfoTask(intent: Intent?)
    }
}