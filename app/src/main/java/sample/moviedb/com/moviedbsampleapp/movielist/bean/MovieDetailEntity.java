package sample.moviedb.com.moviedbsampleapp.movielist.bean;

import java.util.List;

public class MovieDetailEntity {

    public String homepage;
    public List<CompanyEntity> production_companies;
    public String tagline;
    public String overview;

    class CompanyEntity {
        public String name;
    }

}
