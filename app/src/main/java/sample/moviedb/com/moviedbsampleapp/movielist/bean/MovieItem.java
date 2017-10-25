package sample.moviedb.com.moviedbsampleapp.movielist.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by navas on 25/10/17.
 */

public class MovieItem {
    public boolean adult;

    @SerializedName("backdrop_path")
    public String backDropPath;

    public int id;

    @SerializedName("original_title")
    public String originalTitle;

    @SerializedName("release_date")
    public String releaseDate;

    @SerializedName("poster_path")
    public String posterPath;

    public String title;

    public boolean video;

    @SerializedName("vote_average")
    public float voteAverage;

    @SerializedName("vote_count")
    public int voteCount;

}
