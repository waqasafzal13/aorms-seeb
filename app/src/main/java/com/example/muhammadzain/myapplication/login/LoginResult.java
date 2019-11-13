package com.example.muhammadzain.myapplication.login;

import androidx.annotation.Nullable;

/**
 * Authentication result : success (user details) or error message.
 */
class LoginResult {
    @Nullable
    private com.example.muhammadzain.myapplication.login.LoggedInUserView success;
    @Nullable
    private Integer error;

    LoginResult(@Nullable Integer error) {
        this.error = error;
    }

    LoginResult(@Nullable com.example.muhammadzain.myapplication.login.LoggedInUserView success) {
        this.success = success;
    }

    @Nullable
    com.example.muhammadzain.myapplication.login.LoggedInUserView getSuccess() {
        return success;
    }

    @Nullable
    Integer getError() {
        return error;
    }
}
