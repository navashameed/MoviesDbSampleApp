package sample.moviedb.com.moviedbsampleapp.base;

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;

import rx.subscriptions.CompositeSubscription;

/**
 * Created by navas on 25/10/17.
 */

public abstract class BaseMvpPresenter<V extends BaseMvpView> extends MvpBasePresenter<V>{

    private final CompositeSubscription compositeSubscription = new CompositeSubscription();

    @Override
    public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);
        if (!retainInstance) {
            // we use unsubscribe, so in case other subscriptions get added they are unsubscribed immediately
            compositeSubscription.unsubscribe();
        }
    }

    public CompositeSubscription getCompositeSubscription() {
        return compositeSubscription;
    }
}
