package com.android.abhishekpant.andoridmvp.model;

import android.os.Handler;
import android.text.TextUtils;

public class LoginInteractor {

    public interface OnLoginFinishedListener{

        void onUserEmailError();

        void onPasswordError();

        void onSuccess();
    }

    public void login(final String email, final String password, final OnLoginFinishedListener listener) {
        // Mock login. I'm creating a handler to delay the answer a couple of seconds
        new Handler().postDelayed(() -> {
            if (TextUtils.isEmpty(email)) {
                listener.onUserEmailError();
                return;
            }
            if (TextUtils.isEmpty(password)) {
                listener.onPasswordError();
                return;
            }
            listener.onSuccess();
        }, 2000);
    }
}
