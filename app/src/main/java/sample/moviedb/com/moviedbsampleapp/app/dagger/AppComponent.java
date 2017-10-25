package sample.moviedb.com.moviedbsampleapp.app.dagger;

/**
 * Created by navas on 25/10/17.
 */

import dagger.Component;
import rx.Scheduler;
import sample.moviedb.com.moviedbsampleapp.service.MoviesService;
import sample.moviedb.com.moviedbsampleapp.utils.SharedPreferencesApp;

@SingleInstanceIn(AppComponent.class)
@Component(modules = {AppModule.class})
public interface AppComponent {

    MoviesService getMoviesService();

    @IOScheduler
    Scheduler getIOScheduler();

    @MainScheduler
    Scheduler getMainScheduler();

    SharedPreferencesApp getAppSharedPref();

}
