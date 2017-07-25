package fm.kirtsim.kharos.daggertutorial.common.settings.SharedPreferences;

import android.content.SharedPreferences;

import fm.kirtsim.kharos.daggertutorial.common.settings.SettingsDataEntry;
import fm.kirtsim.kharos.daggertutorial.common.settings.SettingsEntryFactory;

/**
 * Created by kharos on 23/07/2017
 */

public class SharedPrefsSettingsFactory extends SettingsEntryFactory {

    private final SharedPreferences sharedPreferences;

    public SharedPrefsSettingsFactory(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> SettingsDataEntry<T> getDataEntry(Class<T> _class, String key, T defaultValue) {
        if (_class == Boolean.class) return (SettingsDataEntry<T>)
                new SharedPrefsBooleanEntry(sharedPreferences, key, (Boolean) defaultValue);
        if (_class == Integer.class) return (SettingsDataEntry<T>)
                new SharedPrefsIntegerEntry(sharedPreferences, key, (Integer) defaultValue);
        if (_class == Long.class) return (SettingsDataEntry<T>)
                new SharedPrefsLongEntry(sharedPreferences, key, (Long) defaultValue);
        if (_class == Float.class) return (SettingsDataEntry<T>)
                new SharedPrefsFloatEntry(sharedPreferences, key, (Float) defaultValue);
        if (_class == Double.class) return (SettingsDataEntry<T>)
                new SharedPrefsDoubleEntry(sharedPreferences, key, (Double) defaultValue);
        if (_class == String.class) return (SettingsDataEntry<T>)
                new SharedPrefsStringEntry(sharedPreferences, key, (String) defaultValue);
        throw new IllegalArgumentException("Class " + _class.getSimpleName()
                + " is not supported yet");
    }
}
