package com.example.retrofitmvvm;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public RecyclerView recyclerView;
    public ArrayList<Model> modelClassArrayList;
    public LinearLayoutManager linearLayoutManager;
    public Adapter adapter;
    private ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        modelClassArrayList = new ArrayList<>();
        linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new Adapter(getApplicationContext(),modelClassArrayList);
        recyclerView.setAdapter(adapter);

        findNews();

    }


//should i run now??wait

    // run nowokkk

    // convert it to model remove apiresponse and brother I have tried that from the morning but it just dont.....works
    private void findNews() {

        RetrofitInstance.getRetrofitInstance().getAllPosts().enqueue(new Callback<ApiResponse>() {
            //Can I show you some thing
            //I have done the similar project waitt...
            @Override
            public void onResponse(@NonNull Call<ApiResponse> call, @NonNull Response<ApiResponse> response) {
                if(!response.isSuccessful()) {//I think this line has some issues no it is checking and nothing, lets try by !response.isSucessful()
                    if(response.body() != null) {
                        modelClassArrayList.addAll(response.body().getCall());
                        Log.v("taggy", String.valueOf(modelClassArrayList.addAll(response.body().getCall())));
//                        adapter.notifyDataSetChanged();
                    }else {
                        Toast.makeText(MainActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                    }
                }
                //Brother response class is needed for the Arraylist
                Toast.makeText(MainActivity.this,"its Responding"+call.toString()+"dd"+response,Toast.LENGTH_SHORT).show();
                Log.d("taggy", "onResponse: "+"its Responding: "+call.toString()+"dd"+response);
            }

            @Override
            public void onFailure(@NonNull Call<ApiResponse> call, @NonNull Throwable t) {
                //this method is calling right??
                //yup
                Toast.makeText(MainActivity.this,"its not Responding: "+call.toString()+"dd"+t,Toast.LENGTH_SHORT).show();
                Log.d("taggy", "onFailure: "+"its not Responding: "+call.toString()+" \n dd: "+t);
            }
            //Same error
        });
    }
//Is it okay brother now good

    //    private void findNews() {
//
//        RetrofitInstance.getRetrofitInstance().getAllPosts().enqueue(new Callback<ApiResponse>() {
//            @Override
//            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
//                Log.d("taggy", "onResponse: "+response+"\ncall: "+call);
//            }
//
//            @Override
//            public void onFailure(Call<ApiResponse> call, Throwable t) {
//                Log.d("taggy", "onFaliure: "+t+"\ncall: "+call);
//            }
//        });
//
//    }


}