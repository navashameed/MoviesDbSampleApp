package sample.moviedb.com.moviedbsampleapp.base;

import com.hannesdorfmann.mosby3.mvp.MvpView;

/**
 * Created by navas on 25/10/17.
 */

public interface BaseMvpView extends MvpView {

    void showProgressDialog();

    void hideProgressDialog();

    void showDialog(String title, String message);

    void showErrorDialog();

}
