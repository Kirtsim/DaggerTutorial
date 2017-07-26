package fm.kirtsim.kharos.daggertutorial;

import android.app.Application;
import android.support.annotation.UiThread;

import fm.kirtsim.kharos.daggertutorial.dependencyinjection.application.ApplicationComponent;
import fm.kirtsim.kharos.daggertutorial.dependencyinjection.application.ApplicationModule;
import fm.kirtsim.kharos.daggertutorial.dependencyinjection.application.DaggerApplicationComponent;
import fm.kirtsim.kharos.daggertutorial.dependencyinjection.application.SettingsModule;

/**
 * Created by kharos on 23/07/2017
 */

public class MyApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @UiThread
    public ApplicationComponent getApplicationComponent() {
        if (applicationComponent == null) {
            applicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(this))
                    .settingsModule(new SettingsModule())
                    .build();
        }
        return applicationComponent;
    }
}