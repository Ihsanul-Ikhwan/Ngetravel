package com.ihsan.ngetravel.API;

import com.ihsan.ngetravel.model.BeliModel;
import com.ihsan.ngetravel.model.UserModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface InsertBeliAPI {
    @FormUrlEncoded
    @POST("insertbeli.php")

    Call<BeliModel> inputBeli(
            @Field("idtiket") String tiket,
            @Field("email") String email,
            @Field("harga") String harga
    );
}
