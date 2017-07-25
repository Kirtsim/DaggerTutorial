package fm.kirtsim.kharos.daggertutorial.common.settings.SharedPreferences;

import android.content.SharedPreferences;

/**
 * Created by kharos on 23/07/2017
 */

public class SharedPrefsLongEntry extends SharedPrefsDataEntry<Long> {

    public SharedPrefsLongEntry(SharedPreferences sharedPreferences, String key, Long defaultValue) {
        super(sharedPreferences, key, defaultValue);
    }

    @Override
    public Long getValue() {
        return sharedPreferences.getLong(key, defaultValue != null ? defaultValue : 0);
    }

    @Override
    public void setValue(Long newValue) {
        if (newValue == null) {
            newValue = defaultValue != null ? defaultValue : 0;
        }
        sharedPreferences.edit().putLong(key, newValue).apply();
    }
}
