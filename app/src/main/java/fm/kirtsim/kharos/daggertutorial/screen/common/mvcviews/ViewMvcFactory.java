package fm.kirtsim.kharos.daggertutorial.screen.common.mvcviews;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import fm.kirtsim.kharos.daggertutorial.screen.example.mvcviews.ExampleViewMvc;
import fm.kirtsim.kharos.daggertutorial.screen.example.mvcviews.ExampleViewMvcImpl;

/**
 * Created by kharos on 23/07/2017
 */

public class ViewMvcFactory {

    private final LayoutInflater layoutInflater;

    public ViewMvcFactory(LayoutInflater layoutInflater) {
        this.layoutInflater = layoutInflater;
    }

    public <T extends ViewMvc>T newMvcView(Class<T> viewClass, ViewGroup container) {
        ViewMvc view;
        if (viewClass == ExampleViewMvc.class) {
            view = new ExampleViewMvcImpl(layoutInflater, container);
        } else {
            throw new IllegalArgumentException("MVC view class " + viewClass + " not supported");
        }
        return (T) view;
    }
}
