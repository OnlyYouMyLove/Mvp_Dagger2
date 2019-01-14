package com.smartisan.mvp_dagger2.mvp.contract;

import com.smartisan.mvp_dagger2.entity.NewsInfo;
import com.smartisan.mvp_dagger2.mvp.presenter.NewsInfoPresenter;
import com.trello.rxlifecycle2.LifecycleProvider;

public interface NewsInfoContract {
    interface Presenter{
        void getNewsInfo(LifecycleProvider lifecycleProvider, String type);
    }

    interface View {
        void setNewsInfo(NewsInfo newsInfo);
        void showLoading();
        void hideLoading();
        void showError();
        void setPresenter(NewsInfoPresenter presenter);
    }
}

