package com.example.roberto.exm2android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.example.roberto.exm2android.firebase.FireBaseAdmin;

public class MAmap extends AppCompatActivity {
    MAmapEvent events;
    Button btnGo;
    EditText txtUser;
    EditText txtPass;
    FireBaseAdmin fireBaseAdmin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fireBaseAdmin = new FireBaseAdmin();
        setContentView(R.layout.MA_main);
        events = new MAmapEvent(this);
        fireBaseAdmin.setFireBaseAdminListener(events);



        btnGo=this.findViewById(R.id.btnGo);
        txtUser=this.findViewById(R.id.txtUser);
        txtPass=this.findViewById(R.id.txtPass);
        btnGo.setOnClickListener(events);


        if (fireBaseAdmin.mAuth.getCurrentUser() != null) {

            fireBaseAdmin.fireBaseAdminListener.logInOk(true);
        }


    }



}
