package com.ihsan.ngetravel.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ihsan.ngetravel.R;

public class TicketActivity extends AppCompatActivity {
    TextView txtasal, txttujuan, txtasal2, txtberangkat, txttujuan2, txtsampai, txtjam, txtharga;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);

        txtasal = findViewById(R.id.asal);
        txttujuan = findViewById(R.id.tujuan);
        txtasal2 = findViewById(R.id.asal2);
        txtberangkat = findViewById(R.id.berangkat);
        txttujuan2 = findViewById(R.id.tujuan2);
        txtsampai = findViewById(R.id.sampai);
        txtjam = findViewById(R.id.jam);
        txtharga = findViewById(R.id.harga);
        back = findViewById(R.id.back);

        String asal = getIntent().getStringExtra("ASAL");
        String tujuan = getIntent().getStringExtra("TUJUAN");
        String berangkat = getIntent().getStringExtra("BERANGKAT");
        String sampai = getIntent().getStringExtra("SAMPAI");
        String jam = getIntent().getStringExtra("JAM");
        String harga = getIntent().getStringExtra("HARGA");

        txtasal.setText(asal);
        txttujuan.setText(tujuan);
        txtasal2.setText(asal);
        txtberangkat.setText(berangkat);
        txttujuan2.setText(tujuan);
        txtsampai.setText(sampai);
        txtjam.setText(jam);
        txtharga.setText("Rp. "+harga+",-");

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}