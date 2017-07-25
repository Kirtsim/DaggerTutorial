package fm.kirtsim.kharos.daggertutorial.common.settings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by kharos on 23/07/2017
 */

public abstract class SettingsDataEntry<T> {

    private final Set<SettingsDataEntryChangeListener<T>> listeners = new HashSet<>(1);

    protected final String key;
    protected final T defaultValue;

    public SettingsDataEntry(String key, T defaultValue) {
        this.key = key;
        this.defaultValue = defaultValue;
    }

    public abstract T getValue();
    public abstract void setValue(T newValue);
    public abstract void remove();

    public final void registerListener(SettingsDataEntryChangeListener<T> listener) {
        synchronized (listeners) {
            boolean added = listeners.add(listener);
            if (added && listeners.size() == 1) {
                onFirstListenerRegistered();
            }
        }
    }

    public final void unregisterListener(SettingsDataEntryChangeListener<T> listener) {
        synchronized (listeners) {
            boolean unregisterd = listeners.remove(listener);
            if (unregisterd && listeners.isEmpty()) {
                onLastListenerUnregistered();
            }
        }
    }

    protected void onFirstListenerRegistered() {}

    protected void onLastListenerUnregistered() {}


    @SuppressWarnings("UnusedParameters")
    protected void notifyListeners(String key, T value) {
        final List<SettingsDataEntryChangeListener<T>> listenersCopy;
        synchronized (listeners) {
            listenersCopy = new ArrayList<>(listeners);
        }
        for (SettingsDataEntryChangeListener<T> listener : listenersCopy) {
            listener.onValueChanged(this, value);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;

        SettingsDataEntry<?> other = (SettingsDataEntry<?>) obj;
        return key.equals(other.key);
    }

    @Override
    public int hashCode() {
        return this.key.hashCode();
    }
}
