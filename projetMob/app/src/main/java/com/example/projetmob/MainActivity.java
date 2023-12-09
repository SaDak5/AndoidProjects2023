/*
package com.example.projetmob;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.projetmob.model.Emissions;
import com.example.projetmob.service.listRepoServiceAPI;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    List<String> data =new ArrayList<>();
    List<Emissions> emissionslist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editTextQuery = findViewById(R.id.editTextQuery);
        Button buttonSearch = findViewById(R.id.buttonSearch);
        ListView listViewShows = findViewById(R.id.listViewShows);

        //ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        //listViewShows.setAdapter(arrayAdapter);

        Retrofit retrofit =new Retrofit.Builder()
                .baseUrl("https://api.tvmaze.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String query=editTextQuery.getText().toString();
                    final listRepoServiceAPI listRepoServiceAPI=retrofit.create(listRepoServiceAPI.class);
                    Call<List<Emissions>> callGitShows=listRepoServiceAPI.searchShows(query);
                    callGitShows.enqueue(new Callback<List<Emissions>>() {
                        @Override
                        public void onResponse(Call<List<Emissions>> call, Response<List<Emissions>> response) {
                            if (!response.isSuccessful()) {
                            emissionslist = response.body();
                            List<String> emissionsnames = new ArrayList<>();
                            for(int i = 0;i<emissionslist.size();i++){
                                emissionsnames.add(emissionslist.get(i).show.getName());
                                Log.i("https://api.tvmaze.com/","onResponse : " + emissionslist.get(i).getShow().getName());
                            }
                            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, emissionsnames);
                            listViewShows.setAdapter(arrayAdapter);

                        }}

                        @Override
                        public void onFailure(Call<List<Emissions>> call, Throwable t) {
                            Log.e("error","error");
                        }



                       /* @Override
                        public void onResponse(Call<ListeResponse> call, Response<ListeResponse> response) {
                              Log.i("info",call.request().url().toString());
                              if (!response.isSuccessful()){
                                  Log.i("indo",String.valueOf(response.code()));
                                  return;
                              }
                              ListeResponse listResponse= response.body();
                              for (Emissions emission:listResponse.ems) {

                                 // data.add(String.valueOf(emission.score));
                                  data.add((emission.show.name));
                              }
                              arrayAdapter.notifyDataSetChanged();
                        }*/

                        /*@Override
                        public void onFailure(Call<ListeResponse> call, Throwable t) {
                             Log.e("error","error");
                        }
                    });
            }
        } );

    }
}*/
package com.example.projetmob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.projetmob.model.Emissions;
import com.example.projetmob.service.listRepoServiceAPI;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    List<Emissions> emissionsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editTextQuery = findViewById(R.id.editTextQuery);
        Button buttonSearch = findViewById(R.id.buttonSearch);
        ListView listViewShows = findViewById(R.id.listViewShows);

        RetrofitInstance.getInstance().apiInterface.searchShows().enqueue(new Callback<List<Emissions>>() {
            @Override
            public void onResponse(Call<List<Emissions>> call, Response<List<Emissions>> response) {
                emissionsList = response.body();
                List<String> emissionnames = new ArrayList<>();
                for (int i = 0; i < emissionsList.size(); i++) {
                    emissionnames.add(emissionsList.get(i).show.getName());

                }

                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, emissionnames);
                listViewShows.setAdapter(arrayAdapter);

                // Set item click listener
                listViewShows.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent i = new Intent(MainActivity.this, ShowDetailsActivity.class);

                         i.putExtra("showId", emissionsList.get(position).show.getId());
                         i.putExtra("showUrl", emissionsList.get(position).show.getUrl());
                          i.putExtra("showLanguage", emissionsList.get(position).show.getLanguage());

                        startActivity(i);
                    }
                });
            }

            @Override
            public void onFailure(Call<List<Emissions>> call, Throwable t) {
                Log.e("MainActivity", "Erreur lors de l'appel de l'api" + t.getMessage());
            }
        });
    }
}
