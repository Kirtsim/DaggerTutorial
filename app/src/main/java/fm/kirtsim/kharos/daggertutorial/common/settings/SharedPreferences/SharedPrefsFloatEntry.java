package fm.kirtsim.kharos.daggertutorial.common.settings.SharedPreferences;

import android.content.SharedPreferences;

/**
 * Created by kharos on 23/07/2017
 */

public class SharedPrefsFloatEntry extends SharedPrefsDataEntry<Float> {

    public SharedPrefsFloatEntry(SharedPreferences sharedPreferences, String key, Float defaultValue) {
        super(sharedPreferences, key, defaultValue);
    }

    @Override
    public Float getValue() {
        return sharedPreferences.getFloat(key, defaultValue != null ? defaultValue : 0);
    }

    @Override
    public void setValue(Float newValue) {
        if (newValue == null) {
            newValue = defaultValue != null ? defaultValue : 0;
        }
        sharedPreferences.edit().putFloat(key, newValue).apply();
    }
}
