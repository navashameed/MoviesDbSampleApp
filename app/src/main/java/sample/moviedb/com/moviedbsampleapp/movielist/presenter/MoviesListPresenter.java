package sample.moviedb.com.moviedbsampleapp.movielist.presenter;

import javax.inject.Inject;

import rx.Observer;
import rx.Scheduler;
import rx.Subscription;
import sample.moviedb.com.moviedbsampleapp.BuildConfig;
import sample.moviedb.com.moviedbsampleapp.app.Constants;
import sample.moviedb.com.moviedbsampleapp.app.dagger.IOScheduler;
import sample.moviedb.com.moviedbsampleapp.app.dagger.MainScheduler;
import sample.moviedb.com.moviedbsampleapp.base.BaseMvpPresenter;
import sample.moviedb.com.moviedbsampleapp.movielist.bean.GetImageConfigurationResponse;
import sample.moviedb.com.moviedbsampleapp.movielist.bean.MoviesListResponse;
import sample.moviedb.com.moviedbsampleapp.movielist.view.MoviesListView;
import sample.moviedb.com.moviedbsampleapp.service.MoviesService;
import sample.moviedb.com.moviedbsampleapp.utils.SharedPreferencesApp;

/**
 * Created by navas on 25/10/17.
 */

public class MoviesListPresenter extends BaseMvpPresenter<MoviesListView> {

    MoviesService moviesService;

    Scheduler mainThreadScheduler;

    Scheduler ioThreadScheduler;

    SharedPreferencesApp sharedPref;

    public MoviesListPresenter(MoviesService moviesService, Scheduler mainThreadScheduler, Scheduler ioThreadScheduler, SharedPreferencesApp sharedPref) {
        this.moviesService = moviesService;
        this.mainThreadScheduler = mainThreadScheduler;
        this.ioThreadScheduler = ioThreadScheduler;
        this.sharedPref = sharedPref;
    }

    public void onActivate() {
        if (sharedPref.readString(Constants.IMAGE_URL_KEY, null) == null) {
            getImageConfig();
        } else {
            getNowRunningMoviesList();
        }
    }

    void getImageConfig() {

        getView().showProgressDialog();

        Subscription subscription = moviesService.getConfigurations(BuildConfig.MDB_API_KEY)
                .observeOn(mainThreadScheduler)
                .subscribeOn(ioThreadScheduler)
                .subscribe(new Observer<GetImageConfigurationResponse>() {

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        getView().hideProgressDialog();
                        getView().showErrorDialog();
                    }

                    @Override
                    public void onNext(GetImageConfigurationResponse getImageConfigurationResponse) {
                        getView().hideProgressDialog();
                        sharedPref.saveString(Constants.IMAGE_URL_KEY, getImageConfigurationResponse.images.base_url);
                        getNowRunningMoviesList();
                    }
                });
        getCompositeSubscription().add(subscription);
    }

    void getNowRunningMoviesList() {
        getView().showProgressDialog();
        Subscription subscription = moviesService.getNowRunningMovies(BuildConfig.MDB_API_KEY)
                .observeOn(mainThreadScheduler)
                .subscribeOn(ioThreadScheduler)
                .subscribe(new Observer<MoviesListResponse>() {

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        getView().hideProgressDialog();
                    }

                    @Override
                    public void onNext(MoviesListResponse moviesListResponse) {
                        getView().hideProgressDialog();
                        String baseImageUrl = sharedPref.readString(Constants.IMAGE_URL_KEY, null);
                        getView().onMovieListLoaded(moviesListResponse.results, baseImageUrl);
                    }
                });
        getCompositeSubscription().add(subscription);
    }
}
