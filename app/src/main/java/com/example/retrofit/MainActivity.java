package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.example.retrofit.adapters.PersonAdapter;
import com.example.retrofit.models.Person;
import com.example.retrofit.models.Result;
import com.example.retrofit.models.Test;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
   Person personList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        getPersonListData();

    }

    private void getPersonListData() {
        // display a progress dialog
        final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setCancelable(false); // set cancelable to false
        progressDialog.setMessage("Please Wait"); // set message
        progressDialog.show(); // show progress dialog

        // Api is a class in which we define a method getClient() that returns the API Interface class object
        // getUsersList() is a method in API Interface class, in this method we define our API sub url
        Api.getClient().getResults(new Callback<Person> () {

            @Override
            public void success(Person userListResponses, Response response) {
                System.err.println("Inside success");

                // in this method we will get the response from API
                progressDialog.dismiss(); //dismiss progress dialog
                personList = userListResponses;
                setDataInRecyclerView(); // call this method to set the data in adapter
            }

            @Override
            public void failure(RetrofitError error) {

                System.err.println("Inside failure");
                // if error occurs in network transaction then we can get the error in this method.
                Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_LONG).show();
                System.err.println(error.toString());

                progressDialog.dismiss(); //dismiss progress dialog

            }
        });
    }

    private void setDataInRecyclerView() {
        List list = new ArrayList();
        list.add(new Test("Tester", "Test@test.com"));
        list.add(new Test("Tester", "Test@test.com"));
        list.add(new Test("Tester", "Test@test.com"));
        list.add(new Test("Tester", "Test@test.com"));
        list.add(new Test("Tester", "Test@test.com"));
        list.add(new Test("Tester", "Test@test.com"));
        list.add(new Test("Tester", "Test@test.com"));
        list.add(new Test("Tester", "Test@test.com"));


        // set a LinearLayoutManager with default vertical orientation
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        // call the constructor of UsersAdapter to send the reference and data to Adapter
        PersonAdapter usersAdapter = new PersonAdapter(MainActivity.this, personList);
        recyclerView.setAdapter(usersAdapter); // set the Adapter to RecyclerView
    }
}