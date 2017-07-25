package fm.kirtsim.kharos.daggertutorial.common.settings.SharedPreferences;

import android.content.SharedPreferences;

/**
 * Created by kharos on 23/07/2017
 */

public class SharedPrefsDoubleEntry extends SharedPrefsDataEntry<Double> {

    public SharedPrefsDoubleEntry(SharedPreferences sharedPreferences, String key, Double defaultValue) {
        super(sharedPreferences, key, defaultValue);
    }

    @Override
    public Double getValue() {
        final double defaultVal = defaultValue != null ? defaultValue : 0;
        return Double.longBitsToDouble(sharedPreferences.getLong(key,
                Double.doubleToLongBits(defaultVal)));
    }

    @Override
    public void setValue(Double newValue) {
        if (newValue == null) {
            newValue = defaultValue != null ? defaultValue : 0;
        }
        sharedPreferences.edit().putLong(key, Double.doubleToLongBits(newValue)).apply();
    }
}
