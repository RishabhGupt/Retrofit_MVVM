package rishabhgupta.app.retrofit_mvvm.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import rishabhgupta.app.retrofit_mvvm.repository.ArticleRepository;
import static rishabhgupta.app.retrofit_mvvm.constant.Constants.API_KEY;
import static rishabhgupta.app.retrofit_mvvm.constant.Constants.ARTICLE_QUERY;
import static rishabhgupta.app.retrofit_mvvm.constant.Constants.CATEGORY;
import static rishabhgupta.app.retrofit_mvvm.constant.Constants.COUNTRY;

import rishabhgupta.app.retrofit_mvvm.room.Article;

public class ArticleViewModel extends AndroidViewModel {

    private ArticleRepository articleRepository;
    private MutableLiveData<List<Article>> mutableLiveData;

    public ArticleViewModel(@NonNull Application application) {
        super(application);

        articleRepository = new ArticleRepository();
        this.mutableLiveData = articleRepository.getMovieArticles(COUNTRY, CATEGORY, API_KEY, application.getApplicationContext());
    }

    public MutableLiveData<List<Article>> getMutableLiveData() {
        return mutableLiveData;
    }
}
