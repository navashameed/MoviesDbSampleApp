package sample.moviedb.com.moviedbsampleapp.movielist.view;

import java.util.List;

import sample.moviedb.com.moviedbsampleapp.base.BaseMvpView;
import sample.moviedb.com.moviedbsampleapp.movielist.bean.MovieItem;

/**
 * Created by navas on 25/10/17.
 */

public interface MoviesListView extends BaseMvpView {
    public void onMovieListLoaded(List<MovieItem> movieItemList, String baseImageUrl);
}
