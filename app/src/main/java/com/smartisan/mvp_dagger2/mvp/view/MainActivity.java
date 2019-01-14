package com.smartisan.mvp_dagger2.mvp.view;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.arch.lifecycle.Lifecycle;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.smartisan.mvp_dagger2.App;
import com.smartisan.mvp_dagger2.R;
import com.smartisan.mvp_dagger2.component.DaggerMainActivityComponent;
import com.smartisan.mvp_dagger2.entity.NewsInfo;
import com.smartisan.mvp_dagger2.finals.Constant;
import com.smartisan.mvp_dagger2.module.NewsInfoModule;
import com.smartisan.mvp_dagger2.mvp.contract.NewsInfoContract;
import com.smartisan.mvp_dagger2.mvp.presenter.NewsInfoPresenter;
import com.trello.lifecycle2.android.lifecycle.AndroidLifecycle;
import com.trello.rxlifecycle2.LifecycleProvider;

import javax.inject.Inject;


public class MainActivity extends AppCompatActivity implements NewsInfoContract.View {

    @Inject
    NewsInfoPresenter mPresenter;
    LifecycleProvider<Lifecycle.Event> lifecycleProvider = AndroidLifecycle.createLifecycleProvider(this);
    private TextView mNew_Content;
    private Dialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerMainActivityComponent.builder().newsInfoModule(new NewsInfoModule(this))
                .netTaskComponent(App.get(this).getNetTaskComponent()).build().inject(this);
        mNew_Content = findViewById(R.id.tv_content);
        mDialog = new ProgressDialog(this);
        mDialog.setTitle(R.string.dialog_get_info);
        findViewById(R.id.bt_get_news).setOnClickListener(v -> {
            mPresenter.getNewsInfo(lifecycleProvider,Constant.DEFAULT_TYPE);
        });
    }

    @Override
    public void setNewsInfo(NewsInfo newsInfo) {
        if (newsInfo != null && newsInfo.getResult() != null && newsInfo.getResult().getData() != null) {
            mNew_Content.setText(newsInfo.getResult().getData().get(0).getTitle());
        }
    }

    @Override
    public void showLoading() {
        mDialog.show();
    }

    @Override
    public void hideLoading() {
        if (mDialog.isShowing())
            mDialog.dismiss();
    }

    @Override
    public void showError() {
        Toast.makeText(this, R.string.toast_net_tip, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(NewsInfoPresenter presenter) {
        mPresenter = presenter;
    }

}
