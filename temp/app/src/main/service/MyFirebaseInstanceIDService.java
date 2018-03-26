package com.example.jiggy.askbindaas.service;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by Abhishek Koranne on 22-03-2018.
 */

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {
    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();

        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d("Error", "Refreshed token: " + refreshedToken);

        // TODO: 04-03-2018 Save in session
    }
}
