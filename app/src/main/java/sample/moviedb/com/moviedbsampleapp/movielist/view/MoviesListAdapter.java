package sample.moviedb.com.moviedbsampleapp.movielist.view;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import sample.moviedb.com.moviedbsampleapp.R;
import sample.moviedb.com.moviedbsampleapp.movielist.bean.MovieItem;

public class MoviesListAdapter extends RecyclerView.Adapter<MoviesListAdapter.MoviesListViewHolder> {

    private List<MovieItem> itemList;
    private Context context;
    private String baseImageUrl;

    public MoviesListAdapter(Context context, List<MovieItem> itemList, String baseImageUrl) {
        this.itemList = itemList;
        this.context = context;
        this.baseImageUrl = baseImageUrl;
    }

    @Override
    public MoviesListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movies_list_item, parent, false);
        MoviesListViewHolder viewHolder = new MoviesListViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MoviesListViewHolder holder, int position) {
        holder.movieName.setText(itemList.get(position).title);
        Picasso.with(context).load(baseImageUrl + "w154" + itemList.get(position).posterPath).into( holder.movieImage);
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }


    public static class MoviesListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView movieName;
        public ImageView movieImage;

        public MoviesListViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            movieName =  itemView.findViewById(R.id.movie_name);
            movieImage =  itemView.findViewById(R.id.movie_image);
        }

        @Override
        public void onClick(View view) {

        }
    }
}