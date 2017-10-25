package sample.moviedb.com.moviedbsampleapp.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import sample.moviedb.com.moviedbsampleapp.movielist.view.activities.MoviesListActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main); //TODO Implement splash screen later
        startActivity(new Intent(this, MoviesListActivity.class));
        finish();
    }
}
