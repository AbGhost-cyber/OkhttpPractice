package com.crushtech.training.mvp;

import static com.crushtech.training.mvp.Contract.Model.onFinishedListener;

public class Presenter implements Contract.Presenter, onFinishedListener {
    private final Contract.Model model;
    private Contract.View mainView;

    public Presenter(Contract.View mainView, Contract.Model model) {
        this.mainView = mainView;
        this.model = model;
    }

    @Override
    public void onButtonClick() {
        if (mainView != null) mainView.showProgress();
        model.fetchNextData(this);
    }

    @Override
    public void onDestroy() {
        mainView = null;
    }

    @Override
    public void onFinished(String string) {
        if (mainView != null) {
            mainView.setData(string);
            mainView.hideProgress();
        }
    }
}
