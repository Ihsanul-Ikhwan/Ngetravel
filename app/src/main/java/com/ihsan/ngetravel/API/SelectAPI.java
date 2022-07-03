package com.ihsan.ngetravel.API;

import com.ihsan.ngetravel.model.TiketModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SelectAPI {

    @GET("showtiket.php")
    Call<List<TiketModel>> callTiket();
}
