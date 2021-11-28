package rishabhgupta.app.retrofit_mvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import rishabhgupta.app.retrofit_mvvm.R;
import rishabhgupta.app.retrofit_mvvm.adapter.MovieAdapter;
import rishabhgupta.app.retrofit_mvvm.room.Article;
import rishabhgupta.app.retrofit_mvvm.view_model.ArticleViewModel;

public class MainActivity extends AppCompatActivity {

    private ProgressBar bar;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearManager;
    private MovieAdapter adapter;
    private ArrayList<Article> articleList = new ArrayList<>();
    private ArticleViewModel articleViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialization();
        getMovieArticles();
    }


    private void initialization() {
        bar = findViewById(R.id.progress_circular_movie_article);
        recyclerView = findViewById(R.id.my_recycler_view);

        linearManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(linearManager);
        recyclerView.setHasFixedSize(true);

        adapter = new MovieAdapter(MainActivity.this, articleList);
        recyclerView.setAdapter(adapter);

        articleViewModel = ViewModelProviders.of(this).get(ArticleViewModel.class);
    }


    private void getMovieArticles() {
        articleViewModel.getMutableLiveData().observe(this, articleResponse -> {
            if(articleResponse!=null) {
                bar.setVisibility(View.GONE);
                articleList.addAll(articleResponse);
                adapter.notifyDataSetChanged();
            }
        });
    }
}