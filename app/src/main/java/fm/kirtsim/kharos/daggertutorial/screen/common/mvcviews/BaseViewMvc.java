package fm.kirtsim.kharos.daggertutorial.screen.common.mvcviews;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.StringRes;
import android.view.View;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by kharos on 23/07/2017
 */

public abstract class BaseViewMvc<ListenerType> implements ObservableViewMvc<ListenerType> {

    private View rootView;
    private Set<ListenerType> listeners = new HashSet<>(1);

    @Override
    public void registerListener(ListenerType listener) {
        listeners.add(listener);
    }

    @Override
    public void unregisterListener(ListenerType listener) {
        listeners.remove(listener);
    }

    public Set<ListenerType> getListeners() {
        return listeners;
    }

    public void setRootView(View view) {
        rootView = view;
    }

    @Override
    public View getRootView() {
        return rootView;
    }

    @Override
    public Bundle getViewState() {
        Bundle bundle = new Bundle();
        getViewState(bundle);
        return bundle;
    }

    @Override
    public void getViewState(Bundle bundle) {
        // nothing!!
    }

    protected <T extends View> T findViewById(@IdRes int id) {
        return (T) rootView.findViewById(id);
    }

    protected Context getContext() {
        return rootView.getContext();
    }

    protected String getString(@StringRes int id) {
        return getContext().getString(id);
    }
}
