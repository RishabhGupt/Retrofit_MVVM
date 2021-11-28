package rishabhgupta.app.retrofit_mvvm.repository;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rishabhgupta.app.retrofit_mvvm.response.ArticleResponse;
import rishabhgupta.app.retrofit_mvvm.retrofit.ApiRequest;
import rishabhgupta.app.retrofit_mvvm.retrofit.RetrofitRequest;
import rishabhgupta.app.retrofit_mvvm.room.Article;
import rishabhgupta.app.retrofit_mvvm.room.ArticleDatabase;

public class ArticleRepository {

    private RetrofitRequest retrofitRequest;
    private ApiRequest apiRequest;

    public ArticleRepository() {
        apiRequest = RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);
    }

    public MutableLiveData<List<Article>> getMovieArticles(String country, String category, String key, Context context) {
        final MutableLiveData<List<Article>> data = new MutableLiveData<>();
        apiRequest.getMovieArticles(country, category, key)
                .enqueue(new Callback<ArticleResponse>() {
                    @Override
                    public void onResponse(Call<ArticleResponse> call, Response<ArticleResponse> response) {
                        if(response.body()!=null) {
                            data.setValue(response.body().getArticles());
                            Toast.makeText(context, "Request Successfull", Toast.LENGTH_SHORT).show();
                            ArticleDatabase.getInstance(context).articleDao().insertList(response.body().getArticles());
                        }
                    }

                    @Override
                    public void onFailure(Call<ArticleResponse> call, Throwable t) {
                        Toast.makeText(context, "Request Failed", Toast.LENGTH_SHORT).show();
                        data.setValue(null);
                        data.setValue(ArticleDatabase.getInstance(context).articleDao().articleList());
                    }
                });
        return data;
    }
}
