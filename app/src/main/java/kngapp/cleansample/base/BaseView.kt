package kngapp.cleansample.base

/**
 * Created by masashi on 2018/08/10.
 *
 * BaseのViewクラス
 */

interface BaseView<T> {
    fun setPresenter(presenter: T)
}