package com.smartisan.mvp_dagger2.mvp.model.interfaces;

import com.trello.rxlifecycle2.LifecycleProvider;

public interface NetTask {
    void execute(LifecycleProvider lifecycleProvider, String type, LoadTasksCallBack callBack);
}
