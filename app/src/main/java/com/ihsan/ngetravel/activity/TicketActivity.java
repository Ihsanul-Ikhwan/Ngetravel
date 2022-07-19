package com.ihsan.ngetravel.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ihsan.ngetravel.API.InsertBeliAPI;
import com.ihsan.ngetravel.R;
import com.ihsan.ngetravel.model.BeliModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TicketActivity extends AppCompatActivity {
    TextView txtidtiket, txtasal, txttujuan, txtasal2, txtberangkat, txttujuan2, txtsampai, txtjam, txtharga, email;
    ImageView back, order;
    private static Retrofit retrofit = null;
    private String baseUrl ="https://ihsanulikhwan.000webhostapp.com/ngetravel/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);


        txtidtiket = findViewById(R.id.idtiket);
        txtasal = findViewById(R.id.asal);
        txttujuan = findViewById(R.id.tujuan);
        txtasal2 = findViewById(R.id.asal2);
        txtberangkat = findViewById(R.id.berangkat);
        txttujuan2 = findViewById(R.id.tujuan2);
        txtsampai = findViewById(R.id.sampai);
        txtjam = findViewById(R.id.jam);
        txtharga = findViewById(R.id.harga);
        back = findViewById(R.id.back);
        order = findViewById(R.id.order);
        email = findViewById(R.id.mail);

        String idtiket = getIntent().getStringExtra("IDTIKET");
        String asal = getIntent().getStringExtra("ASAL");
        String tujuan = getIntent().getStringExtra("TUJUAN");
        String berangkat = getIntent().getStringExtra("BERANGKAT");
        String sampai = getIntent().getStringExtra("SAMPAI");
        String jam = getIntent().getStringExtra("JAM");
        String harga = getIntent().getStringExtra("HARGA");
        String mail = getIntent().getStringExtra("MAIL");

        txtidtiket.setText(idtiket);
        txtasal.setText(asal);
        txttujuan.setText(tujuan);
        txtasal2.setText(asal);
        txtberangkat.setText(berangkat);
        txttujuan2.setText(tujuan);
        txtsampai.setText(sampai);
        txtjam.setText(jam);
        txtharga.setText("Rp. "+harga+",-");
        email.setText("Welcome, "+mail);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertBeli();
            }
        });
    }

    private void insertBeli(){
        retrofit = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();

        InsertBeliAPI insertBeliAPI = retrofit.create(InsertBeliAPI.class);
        Call<BeliModel> call = insertBeliAPI.inputBeli(txtidtiket.getText().toString(), email.getText().toString(), txtharga.getText().toString());
        call.enqueue(new Callback<BeliModel>() {
            @Override
            public void onResponse(Call<BeliModel> call, Response<BeliModel> response) {
                Intent intent = new Intent(TicketActivity.this, SuccessActivity.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<BeliModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}