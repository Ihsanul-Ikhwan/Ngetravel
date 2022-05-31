package com.ihsan.ngetravel.API;

import com.ihsan.restihsanultrpl3b.model.UserModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SelectAPI {

    @GET("selectuser.php")
    Call<List<UserModel>> callUser();
}
