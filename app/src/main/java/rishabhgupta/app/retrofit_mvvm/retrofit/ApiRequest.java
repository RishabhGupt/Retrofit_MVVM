package rishabhgupta.app.retrofit_mvvm.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rishabhgupta.app.retrofit_mvvm.response.ArticleResponse;

public interface ApiRequest {

    @GET("v2/top-headlines/")
    Call<ArticleResponse> getMovieArticles(
        //@Query("q") String query,
        @Query("country") String country,
        @Query("category") String category,
        @Query("apiKey") String apiKey
    );
}
