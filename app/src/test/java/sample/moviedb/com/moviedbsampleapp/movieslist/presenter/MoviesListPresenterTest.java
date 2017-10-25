package sample.moviedb.com.moviedbsampleapp.movieslist.presenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;

import rx.Observable;
import rx.Scheduler;
import sample.moviedb.com.moviedbsampleapp.app.Constants;
import sample.moviedb.com.moviedbsampleapp.app.dagger.IOScheduler;
import sample.moviedb.com.moviedbsampleapp.app.dagger.MainScheduler;
import sample.moviedb.com.moviedbsampleapp.movielist.bean.MoviesListResponse;
import sample.moviedb.com.moviedbsampleapp.movielist.presenter.MoviesListPresenter;
import sample.moviedb.com.moviedbsampleapp.movielist.view.MoviesListView;
import sample.moviedb.com.moviedbsampleapp.service.MoviesService;
import sample.moviedb.com.moviedbsampleapp.utils.SharedPreferencesApp;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by navas on 26/10/17.
 */
//@RunWith(RobolectricTestRunner.class)
public class MoviesListPresenterTest {

    @Mock
    MoviesService moviesService;

    @Mock
    Scheduler mainScheduler;

    @Mock
    Scheduler ioScheduler;

    @Mock
    SharedPreferencesApp sharedPreferencesApp;

    @InjectMocks
    MoviesListPresenter presenter;


    @Mock
    MoviesListView view;

    @Mock
    MoviesListResponse moviesListResponse;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        presenter.attachView(view);
    }

    @Test
    public void onCreditLimitCreate_LoadAccounts() {
        when(sharedPreferencesApp.readString(Constants.IMAGE_URL_KEY, null)).thenReturn("http://dummyurl.com");
        when(moviesService.getNowRunningMovies(any(String.class))).thenReturn(Observable.just(moviesListResponse));

        presenter.onActivate();
        verify(moviesService).getNowRunningMovies(any(String.class));
    }
}
