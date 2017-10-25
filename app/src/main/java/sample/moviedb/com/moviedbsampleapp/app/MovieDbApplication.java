package sample.moviedb.com.moviedbsampleapp.app;

import android.app.Application;

import sample.moviedb.com.moviedbsampleapp.app.dagger.AppComponent;
import sample.moviedb.com.moviedbsampleapp.app.dagger.AppModule;
import sample.moviedb.com.moviedbsampleapp.app.dagger.DaggerAppComponent;

/**
 * Created by navas on 25/10/17.
 */

public class MovieDbApplication extends Application {
    protected AppComponent appComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

}
