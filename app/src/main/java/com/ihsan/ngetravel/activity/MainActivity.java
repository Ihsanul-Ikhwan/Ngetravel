package com.ihsan.ngetravel.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.ihsan.ngetravel.API.ServerAPI;
import com.ihsan.ngetravel.R;
import com.ihsan.ngetravel.adapter.TiketAdapter;
import com.ihsan.ngetravel.model.TiketModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<TiketModel> tiketModelList = new ArrayList<>();
    RecyclerView.LayoutManager lm;
    private LinearLayoutManager llm;

    TiketAdapter tiketAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.listTiket);

        llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        recyclerView.setHasFixedSize(true);
        tiketAdapter = new TiketAdapter(this, tiketModelList);
        recyclerView.setAdapter(tiketAdapter);

        showData();
    }

    private void showData(){
        ServerAPI.getSelectAPI().callTiket().enqueue(new Callback<List<TiketModel>>() {
            @Override
            public void onResponse(Call<List<TiketModel>> call, Response<List<TiketModel>> response) {
                if (response.isSuccessful() && response.body() != null){
                    tiketModelList.addAll(response.body());
                    tiketAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<TiketModel>> call, Throwable t) {

            }
        });
    }
}