package fm.kirtsim.kharos.daggertutorial.common.settings.SharedPreferences;

import android.content.SharedPreferences;

import fm.kirtsim.kharos.daggertutorial.common.settings.SettingsDataEntry;

/**
 * Created by kharos on 23/07/2017
 */

abstract class SharedPrefsDataEntry<T> extends SettingsDataEntry<T>
        implements SharedPreferences.OnSharedPreferenceChangeListener {

    protected final SharedPreferences sharedPreferences;

    public SharedPrefsDataEntry(SharedPreferences sharedPreferences, String key, T defaultValue) {
        super(key, defaultValue);
        this.sharedPreferences = sharedPreferences;
    }

    @Override
    protected void onFirstListenerRegistered() {
        sharedPreferences.registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    protected void onLastListenerUnregistered() {
        sharedPreferences.unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        notifyListeners(key, getValue());
    }

    @Override
    public void remove() {
        sharedPreferences.edit().remove(key).apply();
    }
}
