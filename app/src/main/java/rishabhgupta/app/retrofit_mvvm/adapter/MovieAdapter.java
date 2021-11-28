package rishabhgupta.app.retrofit_mvvm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import rishabhgupta.app.retrofit_mvvm.R;
import rishabhgupta.app.retrofit_mvvm.room.Article;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private Context context;
    private List<Article> articleList;

    public MovieAdapter(Context context, List<Article> articleList) {
        this.context=context;
        this.articleList=articleList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_each_row_movie_article, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Article article = articleList.get(position);
        viewHolder.tvTitle.setText(article.getTitle());
        viewHolder.tvAuthorAndPublishedAt.setText("-"+article.getAuthor() +" | "+"Published At: "+article.getPublishedAt());
        viewHolder.tvDescription.setText(article.getDescription());
        Glide.with(context)
                .load(article.getUrlToImage())
                .into(viewHolder.imgViewCover);
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imgViewCover;
        private final TextView tvTitle;
        private final TextView tvAuthorAndPublishedAt;
        private final TextView tvDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgViewCover=(ImageView) itemView.findViewById(R.id.imgViewCover);
            tvTitle=(TextView) itemView.findViewById(R.id.tvTitle);
            tvAuthorAndPublishedAt=(TextView) itemView.findViewById(R.id.tvAuthorAndPublishedAt);
            tvDescription=(TextView) itemView.findViewById(R.id.tvDescription);
        }
    }
}
