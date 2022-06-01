package com.ihsan.ngetravel.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ihsan.ngetravel.API.InsertAPI;
import com.ihsan.ngetravel.R;
import com.ihsan.ngetravel.model.UserModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends AppCompatActivity {
    TextView login;
    EditText username, email, password;
    Button register;
    private String baseURL="https://ihsanulikhwan.000webhostapp.com/ngetravel/";
    private static Retrofit retrofit = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username = findViewById(R.id.usernameinput);
        email = findViewById(R.id.emailinput);
        password = findViewById(R.id.passwordinput);
        login = findViewById(R.id.login);
        register = findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertDataUser();
                            }
        });

//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
//                startActivity(intent);
//            }
//        });
    }
    private void insertDataUser(){
        retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        InsertAPI insertAPI = retrofit.create(InsertAPI.class);
        Call<UserModel> call = insertAPI.inputUser(username.getText().toString(), email.getText().toString(), password.getText().toString());
        call.enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                username.setText("");
                email.setText("");
                password.setText("");

                Toast.makeText(getApplicationContext(), response.toString()
                        , Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.toString()
                        , Toast.LENGTH_LONG).show();
            }
        });

    }
}