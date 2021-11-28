package rishabhgupta.app.retrofit_mvvm.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Article.class}, version = 2)
public abstract class ArticleDatabase extends RoomDatabase {

    private static final String DATABASE_NAME="article_db";
    private static final Object LOCK = new Object();
    private static ArticleDatabase sInstance;

    public static ArticleDatabase getInstance(Context context) {
        if(sInstance==null) {
            synchronized (LOCK) {
                sInstance = Room.databaseBuilder(context.getApplicationContext(),
                        ArticleDatabase.class, ArticleDatabase.DATABASE_NAME).allowMainThreadQueries().build();
            }
        }
        return sInstance;
    }
    public abstract ArticleDao articleDao();
}
