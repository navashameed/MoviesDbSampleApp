package sample.moviedb.com.moviedbsampleapp.service;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;
import sample.moviedb.com.moviedbsampleapp.movielist.bean.ConfigurationEntity;
import sample.moviedb.com.moviedbsampleapp.movielist.bean.GetImageConfigurationResponse;
import sample.moviedb.com.moviedbsampleapp.movielist.bean.MovieDetailEntity;
import sample.moviedb.com.moviedbsampleapp.movielist.bean.MoviesListResponse;

/**
 * Created by navas on 25/10/17.
 */

public interface MoviesService {

    @GET("configuration")
    Observable<GetImageConfigurationResponse> getConfigurations(@Query("api_key") String apiKey);

    @GET("movie/now_playing")
    Observable<MoviesListResponse> getNowRunningMovies(@Query("api_key") String apiKey);

    @GET("/movie/{id}")
    Observable<MovieDetailEntity> getMovieDetails(@Query("api_key") String apiKey, @Path("id") int movieID);
}
