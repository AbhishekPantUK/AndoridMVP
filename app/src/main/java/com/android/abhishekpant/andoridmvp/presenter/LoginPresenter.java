package com.android.abhishekpant.andoridmvp.presenter;

import com.android.abhishekpant.andoridmvp.model.LoginInteractor;
import com.android.abhishekpant.andoridmvp.view.ILoginView;

public class LoginPresenter implements LoginInteractor.OnLoginFinishedListener{

    private ILoginView loginView;
    private LoginInteractor loginInteractor;

    public LoginPresenter(ILoginView loginView, LoginInteractor loginInteractor) {
        this.loginView = loginView;
        this.loginInteractor = loginInteractor;
    }

    public void validateCredentials(String username, String password) {
        if (loginView != null) {
            loginView.showProgress();
        }

        loginInteractor.login(username, password, this);
    }

    public void onDestroy() {
        loginView = null;
    }

    @Override
    public void onUserEmailError() {
        if (loginView != null) {
            loginView.setUserNameError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onPasswordError() {
        if (loginView != null) {
            loginView.setPasswordError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onSuccess() {
        if (loginView != null) {
            loginView.navigateToHome();
        }
    }
}
