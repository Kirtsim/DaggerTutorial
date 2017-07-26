package fm.kirtsim.kharos.daggertutorial.common.managers;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by kharos on 23/07/2017
 */

public class BaseObservableManager<Listener> {

    private Set<Listener> listeners = Collections.
            newSetFromMap(new ConcurrentHashMap<Listener, Boolean>());

    public void registerListener(Listener listener) {
        listeners.add(listener);
    }

    public void unregisterListener(Listener listener) {
        listeners.remove(listener);
    }

    public Set<Listener> getListeners() {
        return listeners;
    }
}
