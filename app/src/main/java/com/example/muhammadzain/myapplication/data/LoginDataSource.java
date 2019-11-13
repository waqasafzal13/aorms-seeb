package com.example.muhammadzain.myapplication.data;

import com.example.android.seproject.data.model.LoggedInUser;

import java.io.IOException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    public com.example.muhammadzain.myapplication.data.Result<LoggedInUser> login(String username, String password) {

        try {
            // TODO: handle loggedInUser authentication
            LoggedInUser fakeUser =
                    new LoggedInUser(
                            java.util.UUID.randomUUID().toString(),
                            "Jane Doe");
            return new com.example.muhammadzain.myapplication.data.Result.Success<>(fakeUser);
        } catch (Exception e) {
            return new com.example.muhammadzain.myapplication.data.Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
}