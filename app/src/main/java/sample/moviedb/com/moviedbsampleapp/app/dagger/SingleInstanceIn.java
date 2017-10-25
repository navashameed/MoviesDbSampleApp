package sample.moviedb.com.moviedbsampleapp.app.dagger;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * * We can use this universally to mark provides methods as a single instance in a dagger component!
 */
@Scope
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface SingleInstanceIn {
    /**
     * This should be the DaggerComponent.class because every single instance is part of a scope in a dagger component
     * @return
     */
    Class<?> value();
}
