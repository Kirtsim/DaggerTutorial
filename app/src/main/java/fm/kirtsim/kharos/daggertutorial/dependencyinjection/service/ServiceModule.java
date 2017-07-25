package fm.kirtsim.kharos.daggertutorial.dependencyinjection.service;

import android.app.Service;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kharos on 23/07/2017
 */

@Module
public class ServiceModule {

    private final Service service;

    public ServiceModule(Service service) {
        this.service = service;
    }

    @Provides
    public Context context() {
        return service;
    }

    @Provides
    public Service service() {
        return service;
    }
}
