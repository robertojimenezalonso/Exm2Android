package com.example.roberto.exm2android.firebase;


import com.google.firebase.database.DataSnapshot;

/**
 * Created by roberto on 19/2/18.
 */

public interface FireBaseAdminListener {


    public void logInOk(boolean ok);
    public void signOutOk(boolean ok);
    public void fireBaseDownloadBranch(String branch, DataSnapshot dataSnapshot);

}

