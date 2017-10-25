package sample.moviedb.com.moviedbsampleapp.app.dagger;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by kent on 8/2/17.
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface MainScheduler {
}
