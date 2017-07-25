package fm.kirtsim.kharos.daggertutorial.dependencyinjection.application;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import dagger.Module;
import dagger.Provides;
import fm.kirtsim.kharos.daggertutorial.common.Constants;
import fm.kirtsim.kharos.daggertutorial.common.settings.SettingsManager;
import fm.kirtsim.kharos.daggertutorial.common.settings.SharedPreferences.SharedPrefsSettingsFactory;

/**
 * Created by kharos on 23/07/2017
 */

@Module
public class SettingsModule {

    @Provides
    @ApplicationScope
    SettingsManager getSettingsManager(Application application) {
        SharedPreferences sharedPreferences = application.getSharedPreferences(
                Constants.SHARED_PREFS_FILE, Context.MODE_PRIVATE);
        return new SettingsManager(new SharedPrefsSettingsFactory(sharedPreferences));
    }
}
