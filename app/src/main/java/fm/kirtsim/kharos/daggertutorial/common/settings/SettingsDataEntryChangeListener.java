package fm.kirtsim.kharos.daggertutorial.common.settings;

/**
 * Created by kharos on 23/07/2017
 */

public interface SettingsDataEntryChangeListener<T> {

    void onValueChanged(SettingsDataEntry<T> dataEntry, T value);

}
