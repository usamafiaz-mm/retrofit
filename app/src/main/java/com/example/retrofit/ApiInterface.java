package com.example.retrofit;


import com.example.retrofit.models.Person;
import com.example.retrofit.models.Result;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;


public interface ApiInterface {

    // API's endpoints
    @GET("/api/")
    public void getResults(
            Callback<Person> callback);

// UserListResponse is POJO class to get the data from API, In above method we use List<UserListResponse> because the data in our API is starting from JSONArray and callback is used to get the response from api and it will set it in our POJO class

}