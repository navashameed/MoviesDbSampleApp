package sample.moviedb.com.moviedbsampleapp.movielist.view.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;

import sample.moviedb.com.moviedbsampleapp.R;
import sample.moviedb.com.moviedbsampleapp.base.BaseMvpActivity;
import sample.moviedb.com.moviedbsampleapp.movielist.presenter.MovieDetailPresenter;
import sample.moviedb.com.moviedbsampleapp.movielist.view.MovieDetailView;

/**
 * Created by navas on 25/10/17.
 */

public class MovieDetailActivity extends BaseMvpActivity<MovieDetailView, MovieDetailPresenter> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_details);
    }

    @NonNull
    @Override
    public MovieDetailPresenter createPresenter() {
        return null;
    }
}
