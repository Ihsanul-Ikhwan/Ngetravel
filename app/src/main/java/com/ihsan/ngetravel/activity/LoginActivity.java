package com.ihsan.ngetravel.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ihsan.ngetravel.API.LoginAPI;
import com.ihsan.ngetravel.R;
import com.ihsan.ngetravel.model.UserModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {
    TextView daftar;
    EditText email, password;
    Button loginButton;
    private String baseURL="https://ihsanulikhwan.000webhostapp.com/ngetravel/";
    private static Retrofit retrofit = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = findViewById(R.id.inputEmail);
        password = findViewById(R.id.passwordinput);
        loginButton = findViewById(R.id.login);
        daftar = findViewById(R.id.daftar);
        loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                CheckDataUser();
            }
        });
        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
    private void CheckDataUser(){
        retrofit = new Retrofit.Builder().baseUrl(baseURL).addConverterFactory(GsonConverterFactory.create()).build();

        LoginAPI loginAPI = retrofit.create(LoginAPI.class);
        Call<UserModel> call = loginAPI.UserLogin(email.getText().toString(), password.getText().toString());
        call.enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);


//                if (email.getText().toString() == null || password.getText().toString() == null){
//                    Toast.makeText(LoginActivity.this, "Email dan Password Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
//                }else {
//                    if (response.code()==200){
//                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                        startActivity(intent);
//
//                    }else{
//                        Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_LONG).show();
//                    }
//                }
            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}