package com.example.clitz_arestaurantapp;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;

import com.example.clitz_arestaurantapp.Model.CustomerDetails;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class DeliveryFragment extends Fragment {

    private final String esource="Sopan Heights Rajkot";

    EditText Name,Number, Address, City,State,Pincode;
    Button btnorder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup v = (ViewGroup) inflater.inflate(R.layout.fragment_delivery, container, false);

        Name = v.findViewById(R.id.yourName);
        Number = v.findViewById(R.id.yourNumber);
        Address = v.findViewById(R.id.yourAddress);
        City = v.findViewById(R.id.yourCity);
        State = v.findViewById(R.id.yourState);
        Pincode = v.findViewById(R.id.yourPincode);
        btnorder = v.findViewById(R.id.placeOrderButton);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("Customer Details");

        btnorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Name.getText().toString().equals("") || Number.getText().toString().equals("") || Address.getText().toString().equals("") || City.getText().toString().equals("") || State.getText().toString().equals("") || Pincode.getText().toString().equals("")) {
                    Toast.makeText(getContext(), "Please enter details correctly", Toast.LENGTH_SHORT).show();
                }
                else {
                final ProgressDialog mDialog = new ProgressDialog(getContext());
                mDialog.setMessage("Please wait...");
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        mDialog.dismiss();
                        CustomerDetails customerDetails = new CustomerDetails(Name.getText().toString(), Number.getText().toString(), Address.getText().toString(), City.getText().toString(), State.getText().toString(), Pincode.getText().toString());
                        table_user.child(Number.getText().toString()).setValue(customerDetails);
                        //Toast.makeText(getContext(), "Place Order Successfully", Toast.LENGTH_SHORT).show();

                        String sdest = Address.getText().toString().trim();

                        if(sdest.equals(""))
                        {
                            Toast.makeText(getContext(),"Enter Destination",Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            displaytrack(esource,sdest);
                        }

                        notification();

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
                }
            }
        });

        return v;
    }

    private void displaytrack(String source,String dest) {
        try {
            Uri uri = Uri.parse("https://www.google.co.in/maps/dir/" + source + "/" + dest);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.setPackage("com.google.android.apps.maps");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Uri uri = Uri.parse("https://google.com/store/apps/details?id=com.google.android.apps.maps");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }

    private void notification(){

        String name = Name.getText().toString();
        String message = " Your Order Is Placed.";
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel=new NotificationChannel("n","n", NotificationManager.IMPORTANCE_DEFAULT);

            NotificationManager manager= getActivity().getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder builder= new NotificationCompat.Builder(getContext(),"n")
                .setContentText("Clitz - A Restaurant App")
                .setSmallIcon(R.drawable.notification)
                .setAutoCancel(true)
                .setContentText(name + message);

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(getContext());
        managerCompat.notify(999,builder.build());
    }

}

