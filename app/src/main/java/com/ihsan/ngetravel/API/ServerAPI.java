package com.ihsan.ngetravel.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServerAPI {
    public static final String baseURL = "https://ihsanulikhwan.000webhostapp.com/ngetravel/";
//    public static final String baseLocal = "https://10.0.2.2/";
    private static Retrofit retrofit = null;

    public static com.ihsan.ngetravel.API.SelectAPI getSelectAPI(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

//            GitHubService service = retrofit.create(GitHubService.class);
        }
        return retrofit.create(com.ihsan.ngetravel.API.SelectAPI.class);
    }

    public static Retrofit serverConn(){
        if(serverConn()==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

//            GitHubService service = retrofit.create(GitHubService.class);
        }
        return retrofit;
    }
}
