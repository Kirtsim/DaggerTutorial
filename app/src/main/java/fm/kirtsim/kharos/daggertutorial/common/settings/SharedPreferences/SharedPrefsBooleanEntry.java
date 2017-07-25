package fm.kirtsim.kharos.daggertutorial.common.settings.SharedPreferences;

import android.content.SharedPreferences;

/**
 * Created by kharos on 23/07/2017
 */

public class SharedPrefsBooleanEntry extends SharedPrefsDataEntry<Boolean> {

    public SharedPrefsBooleanEntry(SharedPreferences sharedPreferences, String key,
                                   Boolean defaultValue) {
        super(sharedPreferences, key, defaultValue);
    }

    @Override
    public Boolean getValue() {
        return sharedPreferences.getBoolean(key, defaultValue == null ? false : defaultValue);
    }

    @Override
    public void setValue(Boolean newValue) {
        if (newValue == null) {
            newValue = defaultValue == null ? false : defaultValue;
        }
        sharedPreferences.edit().putBoolean(key, newValue).apply();
    }
}
