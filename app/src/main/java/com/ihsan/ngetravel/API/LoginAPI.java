package com.ihsan.ngetravel.API;

import com.ihsan.ngetravel.model.UserModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginAPI {
    @FormUrlEncoded
    @POST("logining.php")
    Call<UserModel> UserLogin(
            @Field("email") String email,
            @Field("password") String password
    );
}
