package fm.kirtsim.kharos.daggertutorial.common.settings;

/**
 * Created by kharos on 23/07/2017
 */

public class SettingsManager {

    private static final String KEY_EXAMPLE_SETTING = "KEY_EXAMPLE_SETTING";

    private final SettingsEntryFactory settingsEntryFactory;

    public SettingsManager(SettingsEntryFactory settingsEntryFactory) {
        this.settingsEntryFactory = settingsEntryFactory;
    }

    public SettingsDataEntry<String> getExampleEntry() {
        return settingsEntryFactory.getDataEntry(String.class, KEY_EXAMPLE_SETTING, "default");
    }
}
