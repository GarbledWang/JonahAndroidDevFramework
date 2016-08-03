package com.jonah.jonahworld.base;

/**
 * @author JonahWang
 *         Created by JonahWang on 2016/7/11.
 */
public interface BasePresenter<V extends BaseView> {
    void attachView(V baseView);
    void detachView();
}
