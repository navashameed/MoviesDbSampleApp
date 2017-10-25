package sample.moviedb.com.moviedbsampleapp.movielist.inject;

import dagger.Component;
import sample.moviedb.com.moviedbsampleapp.app.dagger.AppComponent;
import sample.moviedb.com.moviedbsampleapp.app.dagger.SingleInstanceIn;
import sample.moviedb.com.moviedbsampleapp.movielist.presenter.MovieDetailPresenter;
import sample.moviedb.com.moviedbsampleapp.movielist.presenter.MoviesListPresenter;
import sample.moviedb.com.moviedbsampleapp.movielist.view.activities.MovieDetailActivity;
import sample.moviedb.com.moviedbsampleapp.movielist.view.activities.MoviesListActivity;

/**
 * Created by navas on 25/10/17.
 */

@SingleInstanceIn(MoviesListComponent.class)
@Component(modules = MoviesListModule.class, dependencies = AppComponent.class)
public interface MoviesListComponent {
    void inject(MoviesListActivity moviesListActivity);

    void inject(MovieDetailActivity movieDetailActivity);

    MoviesListPresenter getMoviesListPresenter();

    MovieDetailPresenter getMoviesDetailPresenter();

}
