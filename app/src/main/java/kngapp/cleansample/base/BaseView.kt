package kngapp.cleansample.base

/**
 * Created by masashi on 2018/08/10.
 *
 * Base View クラス
 */

interface BaseView<T> {
    fun setPresenter(presenter: T)
}