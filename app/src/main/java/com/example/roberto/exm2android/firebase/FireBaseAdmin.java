package com.example.roberto.exm2android.firebase;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by roberto on 19/2/18.
 */

public class FireBaseAdmin {
    public FirebaseAuth mAuth;
    public FireBaseAdminListener fireBaseAdminListener;
    public FirebaseDatabase database;
    public DatabaseReference myRef;

    public FireBaseAdmin() {

        mAuth = FirebaseAuth.getInstance();
        this.database = FirebaseDatabase.getInstance();
        myRef = database.getReference();

    }

    public void singInWithEmailAndPassword(String email, String password) {

        if (mAuth.getCurrentUser() != null) {
            // Already signed in
            // Do nothing
            System.out.println("entro");


        } else {
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            System.out.println("acabo de entrar");
                            if (task.isSuccessful()) {

                                fireBaseAdminListener.logInOk(true);

                            }
                        }
                    });
        }

    }

    public void signOut() {

        mAuth.signOut();
        fireBaseAdminListener.signOutOk(true);

    }

    public void setFireBaseAdminListener(FireBaseAdminListener fireBaseAdminListener) {

        this.fireBaseAdminListener = fireBaseAdminListener;

    }

    public void insertBranch(String ruteBranch, Map<String,Object> valores){
        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put(ruteBranch, valores);
        myRef.updateChildren(childUpdates);

    }
    public void insertMultiBranch( Map<String, Object> ruteBranchValue){


        myRef.updateChildren(ruteBranchValue);

    }

    public String generatorKeyBranch(String sRuteBranch){


        return   myRef.child(sRuteBranch).push().getKey();
    }

    public void downAndObserveBranch() {

    }
}
