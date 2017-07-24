package fm.kirtsim.kharos.daggertutorial.dependencyinjection.application;

import android.app.Application;

import dagger.Module;
import dagger.Provides;
import fm.kirtsim.kharos.daggertutorial.common.logging.MyLogger;

/**
 * Created by kharos on 23/07/2017
 */

@Module
public class ApplicationModule {

    private final Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @ApplicationScope
    public Application getApplication() {
        return application;
    }

    @Provides
    @ApplicationScope
    public MyLogger getLogger() {
        return new MyLogger();
    }


}
