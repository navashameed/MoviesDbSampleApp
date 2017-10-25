package sample.moviedb.com.moviedbsampleapp.base;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;

import com.hannesdorfmann.mosby3.mvp.MvpActivity;

import sample.moviedb.com.moviedbsampleapp.app.MovieDbApplication;
import sample.moviedb.com.moviedbsampleapp.app.dagger.AppComponent;

/**
 * Created by navas on 25/10/17.
 */

public abstract class BaseMvpActivity<V extends BaseMvpView, P extends BaseMvpPresenter<V>> extends MvpActivity<V, P> implements BaseMvpView{

    private ProgressDialog progressDialog;

    @Override
    public void showProgressDialog() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("Loading....");
        }
        try {
            progressDialog.show();
        } catch (Exception e) {
            progressDialog = null;
        }
    }

    @Override
    public void hideProgressDialog() {
        try {
            if (progressDialog != null && progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
        } catch (IllegalArgumentException e) {
        }
        progressDialog = null;
    }

    @Override
    public void showDialog(String title, String message) {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    @Override
    public void showErrorDialog() {
        showDialog("Error", "Error retrieving data");
        finish();
    }

    public final AppComponent getAppComponent() {
        return ((MovieDbApplication)getApplication()).getAppComponent();
    }


}
