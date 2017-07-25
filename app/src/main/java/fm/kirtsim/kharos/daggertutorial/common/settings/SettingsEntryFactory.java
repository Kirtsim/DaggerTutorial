package fm.kirtsim.kharos.daggertutorial.common.settings;

/**
 * Created by kharos on 23/07/2017
 */

public abstract class SettingsEntryFactory {

    public abstract <T>SettingsDataEntry<T> getDataEntry(final Class<T> _class,
                                                         final String key, final T defaultValue);

    public <T>SettingsDataEntry<T> getDataEntry(final Class<T> _class, final String key) {
        return getDataEntry(_class, key, null);
    }
}
