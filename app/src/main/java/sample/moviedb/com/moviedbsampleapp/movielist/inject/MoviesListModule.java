package sample.moviedb.com.moviedbsampleapp.movielist.inject;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import sample.moviedb.com.moviedbsampleapp.app.dagger.IOScheduler;
import sample.moviedb.com.moviedbsampleapp.app.dagger.MainScheduler;
import sample.moviedb.com.moviedbsampleapp.app.dagger.SingleInstanceIn;
import sample.moviedb.com.moviedbsampleapp.movielist.presenter.MovieDetailPresenter;
import sample.moviedb.com.moviedbsampleapp.movielist.presenter.MoviesListPresenter;
import sample.moviedb.com.moviedbsampleapp.service.MoviesService;
import sample.moviedb.com.moviedbsampleapp.utils.SharedPreferencesApp;

/**
 * Created by navas on 25/10/17.
 */

@Module
public class MoviesListModule {

    @Provides
    @SingleInstanceIn(MoviesListComponent.class)
    public MoviesListPresenter providesMoviesListPresenter(MoviesService moviesService, @IOScheduler Scheduler ioScheduler, @MainScheduler Scheduler mainScheduler, SharedPreferencesApp sharedPreferencesApp) {
        return new MoviesListPresenter(moviesService, mainScheduler, ioScheduler, sharedPreferencesApp);
    }

    @Provides
    @SingleInstanceIn(MoviesListComponent.class)
    public MovieDetailPresenter providesMovieDetailPresenter() {
        return new MovieDetailPresenter();
    }
}
