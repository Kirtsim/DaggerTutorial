package fm.kirtsim.kharos.daggertutorial.common.settings.SharedPreferences;

import android.content.SharedPreferences;

/**
 * Created by kharos on 23/07/2017
 */

public class SharedPrefsStringEntry extends SharedPrefsDataEntry<String> {

    public SharedPrefsStringEntry(SharedPreferences sharedPreferences, String key, String defaultValue) {
        super(sharedPreferences, key, defaultValue);
    }

    @Override
    public String getValue() {
        return sharedPreferences.getString(key, defaultValue);
    }

    @Override
    public void setValue(String newValue) {
        sharedPreferences.edit().putString(key, newValue);
    }
}
