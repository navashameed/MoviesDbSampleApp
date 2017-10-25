package sample.moviedb.com.moviedbsampleapp.movielist.view.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import sample.moviedb.com.moviedbsampleapp.R;
import sample.moviedb.com.moviedbsampleapp.base.BaseMvpActivity;
import sample.moviedb.com.moviedbsampleapp.movielist.bean.MovieItem;
import sample.moviedb.com.moviedbsampleapp.movielist.inject.DaggerMoviesListComponent;
import sample.moviedb.com.moviedbsampleapp.movielist.inject.MoviesListModule;
import sample.moviedb.com.moviedbsampleapp.movielist.presenter.MoviesListPresenter;
import sample.moviedb.com.moviedbsampleapp.movielist.view.MoviesListAdapter;
import sample.moviedb.com.moviedbsampleapp.movielist.view.MoviesListView;

/**
 * Created by navas on 25/10/17.
 */

public class MoviesListActivity extends BaseMvpActivity<MoviesListView, MoviesListPresenter> implements MoviesListView {

    private GridLayoutManager layoutManager;
    RecyclerView moviesListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movies_list);

        layoutManager = new GridLayoutManager(this, 3);

        moviesListView = findViewById(R.id.movies_list);
        //moviesListView.setHasFixedSize(true);
        moviesListView.setLayoutManager(layoutManager);

        getPresenter().onActivate();

    }


    private void setMoviesAdapter(List<MovieItem> movieItemList, String imageBaseUrl) {
        MoviesListAdapter moviesListAdapter = new MoviesListAdapter(this, movieItemList, imageBaseUrl);
        moviesListView.setAdapter(moviesListAdapter);
    }

    @NonNull
    @Override
    public MoviesListPresenter createPresenter() {
        return DaggerMoviesListComponent.builder()
                .appComponent(getAppComponent())
                .moviesListModule(new MoviesListModule())
                .build()
                .getMoviesListPresenter();
    }

    @Override
    public void onMovieListLoaded(List<MovieItem> movieItemList, String baseImageUrl) {
        setMoviesAdapter(movieItemList, baseImageUrl);
    }
}
