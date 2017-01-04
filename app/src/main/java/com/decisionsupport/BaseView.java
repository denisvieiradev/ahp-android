package com.decisionsupport;

/**
 * Created by denisvieira on 28/12/16.
 */
public interface BaseView<T extends BasePresenter> {
    void setPresenter(T presenter);
}
