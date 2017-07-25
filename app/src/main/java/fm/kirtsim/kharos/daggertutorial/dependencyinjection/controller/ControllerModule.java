package fm.kirtsim.kharos.daggertutorial.dependencyinjection.controller;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import dagger.Module;
import dagger.Provides;
import fm.kirtsim.kharos.daggertutorial.screen.common.dialogs.DialogsFactory;
import fm.kirtsim.kharos.daggertutorial.screen.common.dialogs.DialogsManager;

/**
 * Created by kharos on 23/07/2017
 */

@Module
public class ControllerModule {

    private final FragmentActivity activity;

    public ControllerModule(FragmentActivity activity) {
        this.activity = activity;
    }

    @Provides
    public Context context() {
        return activity;
    }

    @Provides
    public FragmentManager fragmentManager() {
        return activity.getSupportFragmentManager();
    }

    @Provides
    public DialogsManager dialogsManager(FragmentManager fragmentManager) {
        return new DialogsManager(fragmentManager);
    }

    @Provides
    public DialogsFactory dialogsFactory() {
        return new DialogsFactory();
    }
}
