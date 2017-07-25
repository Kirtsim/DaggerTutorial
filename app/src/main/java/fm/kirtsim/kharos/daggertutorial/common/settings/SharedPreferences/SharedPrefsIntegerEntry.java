package fm.kirtsim.kharos.daggertutorial.common.settings.SharedPreferences;

import android.content.SharedPreferences;

/**
 * Created by kharos on 23/07/2017
 */

public class SharedPrefsIntegerEntry extends SharedPrefsDataEntry<Integer> {

    public SharedPrefsIntegerEntry(SharedPreferences sharedPreferences, String key, Integer defaultValue) {
        super(sharedPreferences, key, defaultValue);
    }

    @Override
    public Integer getValue() {
        return sharedPreferences.getInt(key, defaultValue == null ? 0 : defaultValue);
    }

    @Override
    public void setValue(Integer newValue) {
        if (newValue == null) {
            newValue = defaultValue != null ? defaultValue : 0;
        }
        sharedPreferences.edit().putInt(key, newValue).apply();
    }
}
