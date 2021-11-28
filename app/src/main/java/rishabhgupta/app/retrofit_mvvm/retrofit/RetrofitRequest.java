package rishabhgupta.app.retrofit_mvvm.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static rishabhgupta.app.retrofit_mvvm.constant.Constants.BASE_URL;

public class RetrofitRequest {
    private static Retrofit retrofit;

    public static Retrofit getRetrofitInstance() {
        if(retrofit==null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
