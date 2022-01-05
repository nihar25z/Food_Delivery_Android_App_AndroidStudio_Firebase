package com.example.clitz_arestaurantapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.clitz_arestaurantapp.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class login_tab extends Fragment {

    EditText editPhone, editPassword;
    Button btnLogIn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup v = (ViewGroup) inflater.inflate(R.layout.fragment_login_tab, container, false);


        editPhone = v.findViewById(R.id.phone);
        editPassword = v.findViewById(R.id.password);
        btnLogIn = v.findViewById(R.id.log_in);

        //init Firebase
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog mDialog = new ProgressDialog(getContext());
                mDialog.setMessage("Please wait...");
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {


                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        //Check if user not exist in Database
                        if(dataSnapshot.child(editPhone.getText().toString()).exists()) {
                            //Get user information
                            mDialog.dismiss();
                            User user = dataSnapshot.child(editPhone.getText().toString()).getValue(User.class);
                            user.setEmail(editPhone.getText().toString());//set phone
                            if (user.getPassword().equals(editPassword.getText().toString())) {
                                Intent i = new Intent(getContext(), HomeDeliveryLiquidSwipe.class);
                                startActivity(i);
                                Toast.makeText(getContext(), "Sign in success!!!", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getContext(), "Wrong password!!!", Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            mDialog.dismiss();
                            Toast.makeText(getContext(), "User not exist in database!", Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });
        return v;
    }

}



