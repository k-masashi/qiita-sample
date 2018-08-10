package kngapp.cleansample.api

/**
 * Created by masashi on 2018/08/10.
 *
 * Api関連の定数を記述するクラス
 */

class ApiConstants {

    /**
     * APIの名前一覧
     */
    enum class ApiName {
        GET_ARTICLES_API
    }

    companion object {
        // 本来host、ドメインを分離させて管理すべきだが、今回は簡易アプリのためURLを全て格納
        const val GET_ARTICLES_API_URL = "https://qiita.com/api/v2/items?page=1&per_page=10&query="
    }
}