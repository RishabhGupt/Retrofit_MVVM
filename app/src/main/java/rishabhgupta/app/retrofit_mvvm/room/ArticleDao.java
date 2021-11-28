package rishabhgupta.app.retrofit_mvvm.room;

import androidx.room.Dao;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ArticleDao {

    @Query("SELECT * FROM article")
    List<Article> articleList();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertList(List<Article> articles);
}
