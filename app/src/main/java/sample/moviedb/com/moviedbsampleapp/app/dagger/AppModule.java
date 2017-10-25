package sample.moviedb.com.moviedbsampleapp.app.dagger;

import android.annotation.SuppressLint;
import android.app.Application;
import android.preference.Preference;

import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import sample.moviedb.com.moviedbsampleapp.app.Constants;
import sample.moviedb.com.moviedbsampleapp.app.MovieDbApplication;
import sample.moviedb.com.moviedbsampleapp.service.MoviesService;
import sample.moviedb.com.moviedbsampleapp.utils.SharedPreferencesApp;

/**
 * Created by navas on 25/10/17.
 */


@Module
public class AppModule {

    private final MovieDbApplication application;

    public AppModule(MovieDbApplication application) {
        this.application = application;
    }

    @Provides
    @SingleInstanceIn(AppComponent.class)
    MovieDbApplication provideMovieDbApplication() {
        return application;
    }

    @Provides
    @SingleInstanceIn(AppComponent.class)
    OkHttpClient provideOkHttpClient() {
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS);
        return okHttpClientBuilder.build();
    }

    @Provides
    @SingleInstanceIn(AppComponent.class)
    Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    @Provides
    @SingleInstanceIn(AppComponent.class)
    public MoviesService providesMoviesService(Retrofit retrofit) {
        return retrofit.create(MoviesService.class);
    }

    @IOScheduler
    @Provides
    @SingleInstanceIn(AppComponent.class)
    Scheduler provideIOScheduler() {
        return Schedulers.io();
    }

    @MainScheduler
    @Provides
    @SingleInstanceIn(AppComponent.class)
    Scheduler provideMainScheduler() {
        return AndroidSchedulers.mainThread();
    }

    @Provides
    @SingleInstanceIn(AppComponent.class)
    SharedPreferencesApp provideAppSharedPreference(MovieDbApplication application) {
        return new SharedPreferencesApp(application);
    }

}
