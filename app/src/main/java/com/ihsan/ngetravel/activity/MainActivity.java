package com.ihsan.ngetravel.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.ihsan.ngetravel.API.ServerAPI;
import com.ihsan.ngetravel.R;
import com.ihsan.ngetravel.adapter.TiketAdapter;
import com.ihsan.ngetravel.interfaces.TiketInterface;
import com.ihsan.ngetravel.model.TiketModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements TiketInterface {
    private RecyclerView recyclerView;
    private List<TiketModel> tiketModelList = new ArrayList<>();
    RecyclerView.LayoutManager lm;
    private LinearLayoutManager llm;
    TextView email;

    TiketAdapter tiketAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.listTiket);

        llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        recyclerView.setHasFixedSize(true);
        tiketAdapter = new TiketAdapter(this, tiketModelList, this);
        recyclerView.setAdapter(tiketAdapter);

        email = findViewById(R.id.mail);
        String mail = getIntent().getStringExtra("MAIL");
        email.setText("Welcome, "+mail);

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

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(MainActivity.this, TicketActivity.class);

        intent.putExtra("IDTIKET", tiketModelList.get(position).getIdtiket());
        intent.putExtra("ASAL", tiketModelList.get(position).getAsal());
        intent.putExtra("BERANGKAT", tiketModelList.get(position).getBerangkat());
        intent.putExtra("TUJUAN", tiketModelList.get(position).getTujuan());
        intent.putExtra("SAMPAI", tiketModelList.get(position).getSampai());
        intent.putExtra("JAM", tiketModelList.get(position).getJam());
        intent.putExtra("HARGA", tiketModelList.get(position).getHarga());
        intent.putExtra("MAIL", email.getText().toString());

        startActivity(intent);
    }
}