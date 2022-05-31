package com.ihsan.ngetravel.API;

import com.ihsan.restihsanultrpl3b.model.UserModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface InsertAPI {
    @FormUrlEncoded
    @POST("insertuser.php")

    Call<UserModel> inputUser(
            @Field("username") String username,
            @Field("email") String email,
            @Field("password") String password
    );
}
