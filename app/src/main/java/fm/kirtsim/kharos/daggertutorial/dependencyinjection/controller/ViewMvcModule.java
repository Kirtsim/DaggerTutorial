package fm.kirtsim.kharos.daggertutorial.dependencyinjection.controller;

import android.content.Context;
import android.view.LayoutInflater;

import dagger.Module;
import dagger.Provides;
import fm.kirtsim.kharos.daggertutorial.screen.common.mvcviews.ViewMvcFactory;

/**
 * Created by kharos on 23/07/2017
 */

@Module
public class ViewMvcModule {

    @Provides
    public LayoutInflater layoutInflater(Context context) {
        return LayoutInflater.from(context);
    }

    @Provides
    public ViewMvcFactory viewMvcFactory(LayoutInflater layoutInflater) {
        return new ViewMvcFactory(layoutInflater);
    }
}
