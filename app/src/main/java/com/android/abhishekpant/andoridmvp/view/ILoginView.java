package com.android.abhishekpant.andoridmvp.view;

public interface ILoginView {

    void showProgress();

    void hideProgress();

    void setUserNameError();

    void setPasswordError();

    void navigateToHome();

}
